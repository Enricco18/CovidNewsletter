## Trabalho de Arquitetura ##

Protótipo de aplicação que pega dados do site do governo diariamente, e avisa por whatsapp quem estiver inscrito.

### getUpdates

Executará uma rotina diariamente para pegar as novas regras vigentes pegadas no site portal de SP. Se as regras forem diferentes das do dia anterior, lança um evento de atualização.

### userHandler

Irá cadastrar usuários para receber notificações. Ele pegará o evento de atualização e passará mais um evento de aviso para a interface Whatsapp,

### whatsappInterface

Será a interface que enviará as atualizações aos usuários e receberá pedidos para saber como está a situação em tal estado(Ex: !SP).
Intercepta o evento de avisa e manda um whatsapp pro usuário com as informaçòes

## Ferramentas

### H2 (Banco de dados)
### Spring Boot MVC + WEB + Cloud
### Kafka
### Jsoup
### Twillo

## Como rodar o projeto:
Só faça isso se tiver bem afim, criar uma conta no twillo e substitui o AUTHID E TOKEN pelo seu, roda um tunneling com o ngrok no microsserviço do whatsapp e bota essa url na configuração do whatsapp sandbox.

Dai da um docker-compose up 
e roda os microsserviços

uhul
