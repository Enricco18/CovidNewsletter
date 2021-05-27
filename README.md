## Trabalho de Arquitetura ##

Protótipo de aplicação que pega dados do site do governo diariamente, e avisa por whatsapp quem estiver inscrito.

### getUpdates

Executará uma rotina diariamente para verificiar se as informações pegadas no site batem com as que tem no banco, se não estiverem de acordo, irá atualiza-las

### userHandler

Irá cadastrar usuários para receber notificações caso a fase mude, e também 

### whatsappInterface

Será a interface que enviará as atualizações aos usuários e receberá pedidos para saber como está a situação em tal estado(Ex: !SP).
Além de se cadastrar ou descadastrar da newletter

## Ferramentas

### H2 (Banco de dados)
### Spring Boot MVC + WEB + Cloud
### Kafka
### Jsoup
### Twillio
