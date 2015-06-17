/**
 * Created by joanmarc on 12/06/15.
 */
$(document).ready(function () {
    size_li = 20;
    x=size_li;
    $('#myList li:lt('+x+')').show();
    $('#myList blockquote:lt('+x+')').show();
    $('#ShowPlayers').click(function () {
        x= size_li;
        $('#myList li:lt('+x+')').show();
        $('#myList blockquote:lt('+x+')').show();
    });
    $('#HidePlayers').click(function () {
        x=0;
        $('#myList li').not(':lt('+x+')').hide();
        $('#myList blockquote').not(':lt('+x+')').hide();
    });
});