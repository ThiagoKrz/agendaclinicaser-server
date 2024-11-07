funcao gerarRelatorioEstoqueBaixo(inteiro limite)
    escreva("Relatório de Produtos com Estoque Baixo:")
    para cada Produto produto em produtos faca
        se produto.quantidade < limite entao
            escreva("Produto: ", produto.nome, " - Quantidade: ", produto.quantidade)
        fim se
    fim para
fim funcao

// Função para consultar o histórico de movimentações de um produto
funcao consultarHistoricoMovimentacoes(cadeia nomeProduto)
    escreva("Histórico de Movimentações para o Produto: ", nomeProduto)
    para cada Movimentacao movimentacao em movimentacoes faca
        se movimentacao.produto.nome == nomeProduto entao
            escreva("Tipo: ", movimentacao.tipo, " - Quantidade: ", movimentacao.quantidade, " - Data: ", movimentacao.data_movimentacao)
        fim se
    fim para
fim funcao
