(function($){
    $.fn.extend({
        leanModal: function(options) {
            var defaults = {
                top: 50,
                overlay: 0.5,
                overlayId: 'leanOverlay',
                closeButton: null
            }
            options = $.extend(defaults, options);
            
            var overlay = $('<div id="'+ options.overlayId + '"></div>');
            var overlayElem = $('#' + options.overlayId);
        
            $("body").append(overlay);

            return this.each(function() {
                var o = options;
                var ol = $('#' + o.overlayId);
                
                $(this).click(function(e) {
                    var modalId = $(this).attr("href");
                    var isAutoClose = $(this).data('autoclose');

                    ol.click(function() { 
                        if (isAutoClose == true) {
                            closeModal(modalId);
                        }
                    });

                    $(o.closeButton).click(function() { 
                        closeModal(modalId);
                        return false;
                    });

                    var modalHeight = $(modalId).outerHeight();
                    var modalWidth = $(modalId).outerWidth();
                    var customTop = $(this).data('top');

                    ol.css({
                        'display': 'block',
                        'opacity': 0 
                    });
                    ol.fadeTo(200, o.overlay);

                    if (customTop != undefined) {
                        o.top = customTop;
                    }

                    $(modalId).css({ 
                        'display': 'block',
                        'position': 'fixed',
                        'opacity': 0,
                        'zIndex': 23000,
                        'left': 50 + '%',
                        'marginLeft': -(modalWidth / 2) + 'px',
                        'top': o.top + 'px'
                    });
                    $(modalId).fadeTo(200, 1);
                    e.preventDefault();
                });
            });

            function closeModal(modalId){
                $('#' + options.overlayId).fadeOut(200);
                $(modalId).css({
                    'display': 'none'
                });
            }
        }
    });
})(jQuery);