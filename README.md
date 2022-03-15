MVC 框架中，M为Model，指模型 ；V为View，指用户界面；C为Controller，为控制器

对于Model，主要实现业务逻辑，处理数据，相当于layer中的业务逻辑和数据层。

对于View，主要实现用户界面，以浏览器为载体完成前端页面，负责接受用户的输入和展示给用户输出。

对于Controller，主要实现与Model和View之间的交互控制，Controller本身不实现任何业务逻辑，它决定了用户的请求应该调用Model的哪个部件，返回结果应该由哪个View来呈现。

在本作业中，Model实现POS机的功能，View实现POS机的展示界面，Controller可以通过getMapping决定用户的请求交给哪个业务处理模块，用addAttribute实现View展示Model数据。