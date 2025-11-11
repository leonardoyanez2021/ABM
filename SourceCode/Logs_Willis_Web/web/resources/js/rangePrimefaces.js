PrimeFaces.widget.Slider.prototype.bindEvents = function() {
    var $this = this;

    this.jq.bind('slide', function(event, ui) {
        $this.onSlide(event, ui);
    });

    if(this.cfg.onSlideStart) {
        this.jq.bind('slidestart', function(event, ui) {
            $this.cfg.onSlideStart.call(this, event, ui);
        });
    }

    this.jq.bind('slidestop', function(event, ui) {
        $this.onSlideEnd(event, ui);
    });

    this.input.keypress(function(e) {
        var charCode = (e.which) ? e.which : e.keyCode
        if(charCode > 31 && (charCode < 48 || charCode > 57))
            return false;
        else
            return true;
    });

    this.input.keyup(function() {
        alert("pichula");
        if($this.cfg.range) {
            var values = [$this.input.eq(0).val(), $this.input.eq(1).val()].map(Number);
            if(values[0] > values[1]) {
                return false;
            }
            $this.setValues(values);
        } else {
            $this.setValue($this.input.val());
        }
    });
}