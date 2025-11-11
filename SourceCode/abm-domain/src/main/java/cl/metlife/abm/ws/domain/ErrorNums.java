package cl.metlife.abm.ws.domain;

public enum ErrorNums {
    OK(0, "OK"),
    NO_DATA(2, "NO DATA FOUND"),
    CODE_ERROR(3, "CODE ERROR"),
    EMPTY_3(4, "ALL FIELD ARE EMPTY"),
    NO_SOL(5, "SOLICITUD NOT FOUND ON SERVER"),
    NO_LOT(6, "LOTE NOT FOUND ON SERVER"),
    NO_SET(7, "SET or SETS NOT FOUND ON SERVER"),
    PARTIAL_SET(8, "ONLY SOME SETS WERE FOUND ON THE SERVER");
    private final int id;
    private final String nameError;
    ErrorNums(int id, String name) {
        this.id= id;
        this.nameError= name;
    }
    public int getId()
    {
        return this.id;
    }
    public String getNameError(){
        return nameError;
    }

    public static ErrorNums getTagForId(final int id)
    {
        for (final ErrorNums errorNums : values())
            if (errorNums.id == id)
                return errorNums;
        return null;
    }
}
