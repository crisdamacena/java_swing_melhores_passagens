<h1 align="center">Melhores Passagens</h1>

<p>Aplicação desktop para gerenciamento de reservas de passagens aéreas de vôos entre aeroportos brasileiros</p>

## Aqui você vai encontrar:

1. Versão executável do projeto
2. Diagrama de entidades de relacionamento banco de dados
3. Arquivos de instalação do projeto

## Features

- [X] Utilização de interface gráfica Java Swing
- [X] Banco de dados single-threaded SQLite3 incluído na aplicação
- [X] Alteração dinâmica de layout
- [X] Método randômico pra geração de número aleatório
- [X] Métodos para manipulação de datas
- [X] Métodos para conversão e tratamento de dados
- [X] Métodos para gestão de registros no banco de dados
- [X] Tratamentos de exceções
- [X] Mensagens para o usuários (caixas de diálogo)
- [X] Relacionamentos entre instâncias
- [X] Validação de tipos de valores de entrada
- [X] Uso de máscaras para valores de entrada (CPF e telefone)
- [X] Cálculo de valores do tipo double
- [X] Inclusão de informações no banco de dados (CREATE)
- [X] Leitura e exibição de informações registradas no banco de dados (READ)
- [X] Alteração de informações registradas no banco de dados (UPDATE)
- [X] Exclusão de informações registradas no banco de dados (DELETE)

## Como usar

<p>Faça download do conjunto de arquivos neste <a href="https://github.com/crisdamacena/java_swing_melhores_passagens/tree/Release_v1">link</a></p>

<p>Dentro da pasta de sua preferencia, após a descompactação, os arquivos devem estar organizados dessa forma</p>

📁pastaescolhida<br>
&nbsp;&nbsp;&nbsp;&nbsp;|__ 📁 lib<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ commons-dbutils-1.7<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ jcalendar-1.4<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ JMascara1.0<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ junit-4.11<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ mockito-core-1.9.5<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ rs2xml<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__ sqlite-jdbc-3.36.0.1<br>
&nbsp;&nbsp;&nbsp;&nbsp;|__ db_melhores_passagens.db<br>
&nbsp;&nbsp;&nbsp;&nbsp;|__ MelhoresPassagens.jar<br>

<p>Visual do direitório com os arquivos da aplicação executável</p>

![Visual diretório](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/diretorio.PNG)

<p>Clique no arquivo MelhoresPassagens.jar para executar a aplicação</p>
<p>A tela Login aceita quaisquer valores, exceto campos nulos</p>

## Download

### Ambiente

<p>- <a href="https://netbeans.apache.org/download/nb120/nb120.html">IDE NetBeans 12.0+</a></p>
<p>- <a href="https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html">JDK 14.0</a> ou <a href="https://jdk.java.net/java-se-ri/14">Open JDK 14+</a></p>
<p>- <a href="https://www.java.com/en/download/manual.jsp">JRE 1.8.0_301+</a></p>

### Inicialização

<p>- Fazer download dos arquivos da main</p>
<p>- Criar novo projeto novo projeto "Java with Ant > Java Application" no NetBeans com o nome "MelhoresPassagens"</p>
<p>- Substituir arquivos do projeto criado pelos itens baixados</p>
<p>- Executar projeto (F6)</p>

## Descrição

<p>O sistema de gerenciamento de reservas de passagens aéreas Melhores Passagens permite cadastrar e gerenciar passageiros, cadastrar e gerenciar vôos entre aeroportos brasileiros e relacionar passageirosXvôos por meio do cadastro e gerenciamento de reservas.</p>

<p>As telas do projeto são:</p>

1. Splash
2. Login
3. Menu
4. Vôos
5. Passageiros
6. Reservas
7. Cancelamentos


**1. Splash**
<p>Tela com loading de carregamento da aplicação</p>

![Tela Splash](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/splash.PNG)

**2. Login**
<p>Tela login para inserir quaisquer valores de login e senha para entrar. Campos nulos não são aceitos.</p>

![Tela Login](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/login.PNG)

**3. Menu**
<p>Tela menu oferece as opções de gerenciamento.</p>

![Tela Menu](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/menu.PNG)

**4. Vôos**
<p>Tela Vôos exibe, gerencia vôos cadastrados e cadastra novos vôos. O código de vôo é gerado automáticamente unindo três letras do aeroporto de origem, três letras do aeroporto de destino e 4 números aleatórios. É possível inserir a quantidade de vagas disponíveis no vôo. A exibição das datas é pelo vôo mais próximo até o vôo mais distante.</p>

![Tela Vôos](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/voos.PNG)

**5. Passageiros**
<p>Tela Passageiros exibe, gerencia passageiros cadastrados e cadastra novos passageiros. O código DDD do telefone é gerado a partir do estado do passageiro. Cada passageiro pode ser classificado como Criança ou Adulto. A exibição dos passageiros é pelo ID registrado no banco de dados de forma ascendente.</p>

![Tela Passageiros](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/passageiros.PNG)

**6. Reservas**
<p>Tela Reservas exibe, gerencia reservas de passagens cadastradas e cadastra novas reservas de passagens. A reserva de passagem é o relacionamento passageiroXvôo. A partir do ID do passageiro é possível escolher um vôo e inserir o valor da passagem. Caso o passageiro seja Criança, há um desconto de 20% no valor inserido. A exibição das reservas de passagens é pelo ID da passagem registrado no banco de dados de forma ascendente.</p>

![Tela Reservas](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/reservas.PNG)

**7. Cancelamentos**

<p>Tela Cancelamentos exibe, gerencia cancelamentos de reservadas cadastrados e cadastra novos cancelamentos de reservas. A partir do ID da passagem, é possível obter os dados da passagem. Deste modo, basta clicar em "Cancelar Reserva" para que a reserva de passagem saia dos registros do banco de dados. O botão "Limpar Lista" exclui todos os cancelamentos salvos no banco de dados. A exibição dos cancelamentos de reservas é pelo código de vôo registrado no banco de dados de forma ascendente.</p>

![Tela Cancelamentos](https://raw.githubusercontent.com/crisdamacena/java_swing_melhores_passagens/Prints/cancelamentos.PNG)
