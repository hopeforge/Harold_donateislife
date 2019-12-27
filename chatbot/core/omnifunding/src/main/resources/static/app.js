document.getElementById("action-bar").style.display = "flex";
var chatWindow = document.getElementById('messages');

input.addEventListener("keyup", function(event) {
	if (event.keyCode === 13) {
		event.preventDefault();
		document.getElementById("s-button").click();
	}
});

var url = new URL(document.location.href);
let imageAvatar = "./assets/img/bot.png";
var templateBase = $("#baseTpl");

window.onload = function(event) {
	var stompClient = null;
	connect(event);
	var input = document.getElementById("input");
}

function disconnect(event) {
	stompClient.disconnect();
}

function connect(event) {
	// Creating Socket
	var socket = new SockJS("./chat");
	// Creating client over the socket
	stompClient = Stomp.over(socket);
	stompClient.debug = null;
	// Try to connect
	stompClient.connect({}, onConnected, onError);

	event.preventDefault();
}

function onConnected(frame) {
	stompClient.subscribe("/user/topic/chat", onMessageReceived);

	SendMessage("Olá!");
	SendMessage("Eu sou o Mari e estou aqui para te falar sobre o GRAACC que é uma instituição social sem fins lucrativos.");
	
	$('#row-typing').show();
	SendMessage("Gostaria de saber mais sobre nossa instituição?");
	SendMessageButton("", [ {
		label : "Sim",
		execute : "sim1"
	}, {
		label : "Não",
		execute : "nao1"
	} ])

	// stompClient.send("/bot/chat.sendMessage", {},
	// JSON.stringify(messageDTO));

	setTimeout(function() {
		document.getElementById("input").setAttribute("contenteditable", true)
	}, 400);
}

function onError(error) {
	console.log(error);
	console.log("onError");
}

function getTime() {
	var data = new Date();
	horas = data.getHours();
	minutos = data.getMinutes();
	str_horas = new String(horas);
	str_minutos = new String(minutos);
 
	if (str_horas.length < 2)
		str_horas = '0' + str_horas;

	if (str_minutos.length < 2)
		str_minutos = '0' + str_minutos;

	return str_horas + ':' + str_minutos;
}

function onMessageReceived(payload) {
	var message = JSON.parse(payload.body);
	renderMessage(message);
}

function getTime() {
	var data = new Date();
	horas = data.getHours();
	minutos = data.getMinutes();
	str_horas = new String(horas);
	str_minutos = new String(minutos);

	if (str_horas.length < 2)
		str_horas = 0 + str_horas;

	if (str_minutos.length < 2)
		str_minutos = 0 + str_minutos;

	return str_horas + ':' + str_minutos;
}


function SendButtonValue(value, label) {

	document.getElementById("action-bar").style.display = "flex";

	let xH = chatWindow.scrollHeight;
	window.scrollTo(0, xH);
}

function SendMessage(text) {
	var templateRawText = $("#textTpl").html();
	let compiledTemplate = _.template(templateRawText);

	let templateResult = compiledTemplate({
		text : text,
		time : getTime(),
		avatar : imageAvatar
	});

	$(templateResult).insertBefore("#row-typing");
	$("#row-typing").hide();

	$("#messages").animate({
		scrollTop : $('#messages').prop("scrollHeight")
	}, 100);

	setTimeout(function() {
		document.getElementById("input").setAttribute("contenteditable", true)
	}, 400);
	document.getElementById("action-bar").style.display = "flex";
}

function SendMessageButton(text, buttons) {
	let compiledTemplate = _.template($("#buttonsTpl").html());

	let templateResult = compiledTemplate({
		text : text,
		time : getTime(),
		avatar : imageAvatar,
		buttons : buttons
	});

	$(templateResult).insertBefore("#row-typing");
	$("#row-typing").hide();

	$("#messages").animate({
		scrollTop : $('#messages').prop("scrollHeight")
	}, 100);

	$("button.button-response").on("click", function(e) {
		$(e.target).css("background-color", "blue");
		$(e.target).css("color", "white");
		$(e.target).css("font-weight", "bold");
		$("button", $(e.target).parent()).off("click");
		var ev = $(e.target).attr("data-execute");
		if (ev != undefined) {
			actions[ev]();
		}
		e.preventDefault();
	})

	setTimeout(function() {
		document.getElementById("input").setAttribute("contenteditable", true)
	}, 400);

	document.getElementById("action-bar").style.display = "flex";
}

function renderMessage(message) {

	var templateRawText = $("#tplSendMessage").html();

	let compiledTemplateBase = _.template(templateRawText);

	let templateBaseResult = compiledTemplateBase({
		text : message,
		time : getTime(),
		avatar : imageAvatar
	});

	$(templateBaseResult).insertBefore("#row-typing");

	$("#row-typing").hide();

	$("#messages").animate({
		scrollTop : $('#messages').prop("scrollHeight")
	}, 100);

}

function SendButtonValue(value, label) {
	document.getElementById("action-bar").style.display = "flex";

	let xH = chatWindow.scrollHeight;
	window.scrollTo(0, xH);
}

actions = {}
actions['nao1'] = function() {
	SendMessage("Que pena, mais depois da uma olhadinha na historia da minha amiguinha Alice, que foi curada la no GRAAC");
	SendMessage("https://www.youtube.com/watch?v=Db1ddungF_Y&t=74s");
	SendMessage("Até logo");
};

actions['sim1'] = function() {
	SendMessage("Uhuu, vejo que você tem um grande coração... ");
	SendMessage("O GRAACC atende mais de 3 Mil crianças diagnosticadas com cancê, de todo o Brasil, inclusive da sua região...");
	SendMessage("Hoje 70% voltam a crescer saudaveis e ter uma vida feliz!");
	SendMessageButton("", [ {
		label : "Sim",
		execute : "doar"
	}, {
		label : "Não",
		execute : "nao2"
	} ])
};


actions['doar'] = function() {
	SendMessage("O GRAACC prescisa de sua ajuda.. ");
	SendMessage("Por ano, mihares de crianças e adolescentes encontram no Hospital do GRAACC tudo o que prescisam para alcançar a cura do câncer infantil. ");
	SendMessage("Mas isso só e possível porque contamos com a sua ajuda! ");

	SendMessageButton("", [ {
		label : "Ajudar já",
		execute : "ajuda"
	}, {
		label : "Doar qualquer valor",
		execute : "valor"
	}, ])
};


actions['ajuda'] = function() {
	SendMessage("Com sua doação de R$ 15,00 você vai ajuda a adquirir pamadas que evitam a dor antes da punção para receber a quimioterapia, Uau veja o quanto isso vai ajudar varias crianças! ");
	SendMessage("Com sua doação de R$ 35,00 você vai ajuda a adquirir remédios que evitam as náuseas durante a quimioterapia, Uau veja o quanto isso vai ajudar varias crianças! ");
	SendMessage("Com sua doação de R$ 50,00 você vai ajuda a adquirir ataduras coloridas para curativos, que garantem segurança, mas também a diversão em um momento tão dificíl para os pacientes, Uau veja o quanto isso vai ajudar varias crianças! ");

	SendMessageButton("", [ {
		label : "R$ 15,00",
		execute : "15",
	},{
		label : "R$ 35,00",
		execute : "35"
	}, {
		label : "R$ 50,00",
		execute : "50"
	}, ])
	
};

actions['15'] = function() {
	SendMessage("Obrigado por doar! ");
	SendMessage("Você esta ajudando a alcançar a cura do câncer infantil de milhares de crianças. ");
	window.open("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MCMEACJKT3EBS&source=url",'_blank');
		
	SendMessageButton("", [ {
		label : "Saber Mais Sobre GRAACC",
		execute : "0"
	}, {
		label : "Compartilhar essa ideia",
		execute : "1"
	} ])
};