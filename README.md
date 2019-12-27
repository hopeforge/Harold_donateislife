**HACKATHON GRAAC**
========================================================================
1.1 JUSTIFICATIVA

A Noz Pesquisa e Inteligência conduziu uma pesquisa no início de 2019 sobre o doador brasileiro onde apresentou um panorama inédito, destacando principalmente o potencial de doação entre os brasileiros com mais de 50 anos. Entre outras conclusões apresentadas, nota-se também a preferência de 44% desse público por causas envolvendo crianças e jovens, além da contribuição mensal de 31%. Tais valores arrecadados são de extrema valia para a sustentabilidade de instituições sociais e sem fins lucrativos, como o GRAACC, responsável por garantir um tratamento de qualidade contra o câncer à crianças e jovens desde 1991. Entretanto, o próprio GRAACC relata a necessidade de expandir e otimizar sua captação de recursos externos para manter os tratamentos.

Pensando neste problema e no evidente benefício de se obter características de doadores como mostrado pela Noz Pesquisa, propomos uma plataforma única capaz de agrupar dados importantes de doadores, apresentar relatórios e otimizar campanhas de captação de recursos utilizando técnicas de inteligência artificial.

1.2 OBJETIVO DA FERRAMENTA

A ferramente tem como objetivo aumentar o número de captação de recursos das seguintes maneiras: captar novos doadores com recursos direcionados ao público baseado em um sistema de recomendação, manter o interesse pela doação de doadores frequentes e detectar possíveis desistências de doadores.

2. O SISTEMA

2.1 COMO UTILIZAR

O usuário deverá fazer login  para ter acesso as funcionalidades. O sistema irá apresentar um menu com as diversas opções de funcionalidade disponíveis da plataforma. Uma vez escolhida a opção, o usuário será redirecionado para a página da funcionalidade selecionada. As funcionalidades inclusas nessa versão são: Mari, um chatbot para integração com sites que desejarem a ter; Um sistema de classificação, utlizado em redes sociais, focado em encontrar doadores em potencial; Um sistema para retenção e engajamento que analisa, na base pré existente da GRAACC, os diversos perfis de doadores presentes.


2.2 JUSTIFICATIVAS PARA O DESENVOLVIMENTO

Esse projeto foi pensado para que funcionários da GRAACC tenham acesso de forma simples e fácil a uma plataforma totalmente focada, e que ataque em diversas frentes, o problema de arrecadação para a instituição.

2.3 JUSTIFICATIVAS PARA A IDENTIDADE VISUAL

GUSTAVO

3. FUNCIONALIDADES

3.1 Mari – A Chatbot

Uma funcionalidade da plataforma que, através de um código javascript gerado, permite a implatação de um chatbot em qualquer site parceiro da instituição.

3.2 Captação em Redes Sociais

Com a escolha de uma hashtag ou termo, relacionada à instituição, o usuário poderá listar o que está sendo dito em tempo real no Twitter. Em seguida, é calculada a probabilidade dos tweets serem de potenciais doadores. Uma vez listado os tweets, a opção de disparar uma mensagem direta para os perfis selecionados é apresentada ao usuário.

3.3 Retenção e Engajamento

A partir da análise da base de dados da GRAACC, os perfis de doadores previamente cadastrados são classificados de acordo com sua interação de doações com a instituição. A partir destas classificações e-mails, específicos para cada classe, são enviados, aumentando assim as chances de sucesso na arrecadação.

**Dados de Acesso ao Servidor:**

    IP:         172.31.2.59
    USUÁRIO:    ubuntu
    SENHA:      N9sdhpi2Dhn2
    
    Para acesso externo à sua API desenvolvida, utilize o endereço: http://54.183.205.202


Dashboard
========================================================================
Como acessar ao dashboard:
* Usuário: admin@admin.com
* Senha: admin


Tecnologias utilizados:
========================================================================
* Dashboard:
	- Backend : Java 8 (OpenJDK 1.8.0), Spring Boot, MySQL, WebSocket, StompJS, Maven
	- Frontend: Angular 8, ChartJS, D3Js
* Inteligência Artificial:
	- Python 3: Pandas, SckitLearn
	- Algoritimo: RandomForest	
* Módulos auxiliares:
	- Rasa NLU - Motor de processamento de linguagem Natural
	- LandPage


Descritivo de cada módulo:
========================================================================
* LandPage:
	- Folder: land page
	- Descrição: Página contendo a demostração do produto, com objetivo do produto e exemplo do uso do chatbot para captação de novos clientes.

* Dashboard:
	- Folder: chatbot
	- Descrição: Módulo para acompanhamento das rotinas de crawller do twitter e obtenção dos relatórios de confiança em relação a novas doações do mesmo indíviduo.
	 
* hashtagclassifier:
	- Folder : hashtagclassifier
	- Descrição: API que realiza o calculo do indice de confiança por usários obitdos através do twitter;

* crawller:
	- Folder : crawller
	- Descrição: Realiza a busca automáticas por hashtags e por mensagem de Direct;

* rasa:
	- Folder : rasa
	- Descrição: Motor de execução de Processamento Linguagem Natural, configurado com algoritimos da biblioteca tensorflow;

Banco de dados
========================================================================
Como acessar o client do MySQL:

    $ mysql -u root -p
    SENHA: N9sdhpi2Dhn2
    Acesso Web: http://<IP_AMBIENTE>/phpmyadmin/


Processo de execução:
========================================================================
1. Dashboard: 
 $ java -jar chatbot/core/omnifunding/target/omnifunding-0.0.1-SNAPSHOT.jar 

2. Crawller:
 $ python crawller/app.py

3. Landing-Page:
 $ cd 'landing page';
 $ npm install -g http-server
 $ http-server -p 80

4. Rasa
  $ cd rasa 
  $ pip install rasa_nlu
  $ pip install -r requirements.txt
  $ python -m spacy download pt_core_news_sm
  $ python -m rasa_nlu.server -c config.yml --path /rasa/projects