package cl.blueprintsit.business;

import cl.blueprintsit.business.authentication.InvalidRUTException;

import java.io.Serializable;

public class RUT implements Serializable {

    private static RUT dummyRUT = new RUT(1, '9');

    private int number;
    private char verifierNumber;

    public RUT(int number, char verifierNumber) {
        this.number = number;
        this.verifierNumber = verifierNumber;
    }

    /**
     * This method is responsible for parsing a rut representation with a String.
     *
     * @param aRUT The RUT representation.
     * @return A fresh and well formed and valid RUT.
     * @throws cl.metlife.administrador.business.authentication.InvalidRUTException Thrown if the representation can not be parsed to a valid RUT.
     */
    public static RUT parseRUT(String aRUT) throws InvalidRUTException {

        /* Basic validation is performed */
        if ((aRUT == null) || aRUT.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("El RUT no debe ser nulo.");
        }

        ParsedRut parsedRut = parseGeneralForm(aRUT);

        /* Validating the number part of the rut */
        if (!isNumber(parsedRut.numberPart)) {
            throw new InvalidRUTException("La parte numerica del RUT no es numerica: " + Integer.toString(parsedRut
                    .getNumber()));
        }

        if (!isNumber(parsedRut.validationPart) && !parsedRut.validationPart.equalsIgnoreCase("k")) {
            throw new InvalidRUTException("El digito verificador no es un numero o k: ", aRUT);
        }


        RUT rut = new RUT(parsedRut.getNumber(), parsedRut.getVerifier());
        if (!rut.isValid()) {
            throw new InvalidRUTException("El RUT no es válido (el digito verificador no verifica la parte numerica):" +
                    " ", aRUT);
        }

        return rut;
    }

    /**
     * This method is responsible for determining whether a RUT is valid with respect to the verifier number.
     *
     * @return <code>true</code> if the RUT is valid and <code>false</code> otherwise.
     */
    public boolean isValid() {

        int dvT, sum = 0;
        int rut = number;
        int[] factors = {2, 3, 4, 5, 6, 7, 2, 3};
        for (int factor : factors) {
            int dig = rut % 10;
            rut /= 10;
            sum += dig * factor;
        }

        dvT = (11 - (sum % 11)) % 11;
        if (verifierNumber == 'k') {
            return dvT == 10;
        } else {
            return dvT == Integer.parseInt("" + verifierNumber);
        }
    }

    protected static ParsedRut parseGeneralForm(String aRUT) throws InvalidRUTException {

        String rut = aRUT.trim();
        ParsedRut parsedRut;

        /* En este caso se soporta que el ultimo numero sea siempre el numero verificador */
        int dashIndex = rut.indexOf("-");
        if (dashIndex < 0) {
            /* El largo debe ser superior a 1 caracter */
            int rutLength = rut.length();
            if (rutLength < 2) {
                throw new InvalidRUTException("El rut es demasiado pequeño para ser identificado: ", aRUT);
            }

            parsedRut = new ParsedRut(rut.substring(0, rutLength - 1), rut.substring(rutLength - 1, rutLength));
        } else {
            parsedRut = new ParsedRut(rut.substring(0, dashIndex), rut.substring(dashIndex + 1));
        }

        return parsedRut;
    }

    private static boolean isNumber(String possibleNumber) {
        String rawRut = possibleNumber.replace(".", "");

        try {
            Integer.parseInt(rawRut);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return this.number + "-" + this.verifierNumber;
    }

    public Integer getNumber() {
        return this.number;
    }

    public char getVerifierNumber() {
        return this.verifierNumber;
    }

    public static RUT dummyRUT() {
        return dummyRUT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RUT)) return false;

        RUT rut = (RUT) o;

        return number == rut.number && verifierNumber == rut.verifierNumber;

    }

    @Override
    public int hashCode() {
        return number;
    }
}

class ParsedRut {
    String numberPart;
    String validationPart;


    public ParsedRut(String numberPart, String validationPart) {
        this.numberPart = numberPart.trim();
        this.validationPart = validationPart.trim();
    }

    public int getNumber() throws NumberFormatException {
        try {
            return Integer.parseInt(numberPart);
        } catch (NumberFormatException nfe) {
            if (numberPart.contains(".")) {
                return Integer.parseInt(numberPart.replace(".", ""));
            }
            throw new NumberFormatException("La parte numerica del RUT no pudo ser entendida como tal: " + numberPart);
        }
    }

    public char getVerifier() {
        if (validationPart.charAt(0) == 'k' || validationPart.charAt(0) == 'K') {
            return 'k';
        }

        try {
            Integer.parseInt("" + validationPart.charAt(0));
            return validationPart.charAt(0);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("El digito verificador no es un numero o una k.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParsedRut)) return false;

        ParsedRut parsedRut = (ParsedRut) o;

        return numberPart.equals(parsedRut.numberPart) && validationPart.equals(parsedRut.validationPart);

    }

    @Override
    public int hashCode() {
        return numberPart.hashCode();
    }
}