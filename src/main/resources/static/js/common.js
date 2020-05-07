function message(info) {
    $.messager.show({
        title: '提示',
        msg: info,
        timeout: 1000,
        showType: 'show'
    });
}

$.formatString = function (str) {
    for (var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
};

var maskWidth = $(window).width();
var maskHeight = $(window).height();
var maskHtml = "<div id='maskLoading' class='panel-body' style='z-index:1000;position:absolute;left:0;width:100%;";
maskHtml += "height:" + maskHeight + "px;top:0'>";
maskHtml += "<div class='panel-header panel=loading' style='position:absolute;cursor:wait;left:" + ((maskWidth / 2)-100) + "px;top:" + (maskHeight / 2 -50) + "px;width:200px;height:16px;";
maskHtml += "border:0px solid #ccc;background-color:white;'>";
maskHtml += "数据加载中，请等待......";
maskHtml += "</div>";
maskHtml += "</div>";
document.write(maskHtml);
function CloseMask() {
    $('#maskLoading').fadeOut('fast', function () {
        $(this).remove();
    });
}
var loadComplete;
$.parser.onComplete = function () {
    if (loadComplete)
        clearTimeout(loadComplete);
    loadComplete = setTimeout(CloseMask, 500);
}
