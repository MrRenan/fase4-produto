# Microsserviço de catálogo de produtos

Descrição funcional: este microsserviço gerenciará o catálogo de
produtos, incluindo informações detalhadas dos produtos e o controle de
estoque. Uma característica chave será a funcionalidade de carga de produtos,
permitindo a importação em massa de informações de produtos para o sistema.

# Tecnologias e abordagens:

• Spring Boot para desenvolvimento e configuração. <p>
• Spring Data JPA para gerenciamento de dados de produtos em um 
banco de dados. <p>
• Spring Batch para implementar a funcionalidade de carga de produtos,
automatizando a importação de dados de produtos de fontes externas,
como arquivos CSV.

# Funcionalidade de carga de produtos

Descrição funcional: esta funcionalidade específica permitirá a
importação em massa de dados de produtos, incluindo descrições, preços e
quantidades em estoque. A importação poderá ser agendada ou iniciada
manualmente, garantindo que o catálogo de produtos esteja sempre atualizado.
