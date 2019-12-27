let jQueryScript = document.createElement('script');
jQueryScript.setAttribute('src', 'https://code.jquery.com/jquery-3.4.1.min.js');
document.head.appendChild(jQueryScript);

document.querySelector('head').innerHTML += '<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">';

let chat = document.createElement("div");
chat.setAttribute('id', 'chat');
chat.style.zIndex = '9999 !important';
document.body.appendChild(chat);
divChat = document.getElementById('chat');

let iframe = document.createElement("iframe");
iframe.setAttribute('id', 'iframe');
iframe.setAttribute('src', "http://localhost:8080/api/index.html");
divChat.appendChild(iframe);

let buttonChat = document.createElement("div");
buttonChat.setAttribute('id', 'button-chat');
buttonChat.setAttribute('onclick', "myFunction()");
divChat.appendChild(buttonChat);

let icoButton = document.createElement("img");
icoButton.setAttribute('src', 'http://localhost:8080/api/bot.png');
icoButton.setAttribute('style','font-size: 40px;margin-left: 2px;margin-top: 4px;height: 70px; width: 70px ');
icoButton.innerHTML = "message";
buttonChat.appendChild(icoButton);

function myFunction() {
	$("#iframe").toggle('display')
}

if (matchMedia) {
	const mq = window.matchMedia("(max-width: 500px)");
	mq.addListener(WidthChange);
	WidthChange(mq);
}

// media query change
function WidthChange(mq) {
	if (mq.matches) {
		document.getElementById("chat").style = "display: flex; flex-direction: column; align-content: flex-end; align-items: center; height: 100%; width: 100%; bottom: 0; right: 0; position: fixed; margin: 0; padding: 0; z-index: 9999;";
		document.getElementById("iframe").style = "display: none; background-color: rgb(255, 255, 255); height: 90%; width: 100%; border: 0px; padding: 0px; transition: height 0.3s ease-in-out 0s; position: absolute; bottom: 51px; box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;";
		document.getElementById("button-chat").style = "display: flex;flex-direction: column;align-items: center;justify-content: center;height: 50px;width: 100%;background-color: #ffffff;margin: 0;padding: 0;border-radius: 0;color: #fff;cursor: pointer;bottom: 0;margin-bottom: 0;position: fixed;box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);";		
	} else {
		document.getElementById("chat").style = "display: flex; flex-direction: column; align-content: flex-end; align-items: flex-end;  min-height: 70px; max-height: 100%; min-width: 70px; max-width: 400px;  bottom: 0; right: 0; position: fixed; margin: 20px; padding: 0; z-index: 9999; ";
		document.getElementById("iframe").style = "display: flex; right: 10px; background-color: #fff; height: 650px; width: 400px; border: 0; padding: 0;-webkit-transition: height 0.3s ease-in-out;position: absolute;bottom: 80px;box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23); ";
		document.getElementById("button-chat").style = "display: flex; flex-direction: column; align-items: center; justify-content: center;  height: 70px; width: 70px;background-color: #ffffff; margin:0; padding: 0; border-radius: 50%; color: #fff;  cursor: pointer; bottom: 0; margin-bottom: 10px; position: fixed; box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);";
	}
}
