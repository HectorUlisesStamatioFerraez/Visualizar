$('[id^="btn-details"]').click(function(){

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/Servlets_war/findAll',
        data: {
            action: 'findAll'
        }
    }).done(function(res){
        console.log(res);
        let games = res.games;
        $('#lbl_idGames').text(games.idGames);
        $('#lbl_name').text(games.name);
        $('#lbl_datePremiere').text(games.datePremiere);
        $('#lbl_Category_idCategory').text(games.beanCategory.idCategory);
        $('#lbl_status').text(games.status);
    });
});
