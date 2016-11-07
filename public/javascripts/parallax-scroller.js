(function(){

    let parallax = document.querySelectorAll(".parallax"),
        speed = [0.9,0.7,0.5],
        initPos = [20,30,10];

    let transform = ["transform", "msTransform", "webkitTransform", "mozTransform", "oTransform"];
    let transformProperty = getSupportedPropertyName(transform);

    window.onscroll = function(){
        [].slice.call(parallax).forEach(function(el,i){
            let windowYOffset = window.pageYOffset;
            let newPos = (initPos[i] + (windowYOffset * speed[i]));
            el.style[transformProperty] = "translate(0px, " + newPos + "px)";
        });
    };

    function getSupportedPropertyName(properties) {
        for (var i = 0; i < properties.length; i++) {
            if (typeof document.body.style[properties[i]] != "undefined") {
                return properties[i];
            }
        }
        return null;
    }

})();

