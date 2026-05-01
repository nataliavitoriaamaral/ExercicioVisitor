# Padrão Visitor - Sistema de exportação de relatórios

Este repositório contém a implementação do Padrão de Projeto **Visitor** em Java. O projeto foi desenvolvido como atividade prática para a disciplina de Programação Orientada a Objetos (POO).

## O Problema

O sistema possui diferentes tipos de relatórios (texto, imagem e gráfico) e precisa exportá-los para diversos formatos (HTML, planilha e PDF). 

Sem um padrão de projeto, adicionar um novo formato de saída exigiria modificar o código de todas as classes de relatórios existentes, gerando um código difícil de manter e violando o princípio do Aberto/Fechado (Open/Closed Principle) do SOLID.

## A Solução: Padrão Visitor

A solução adotada foi o padrão **Visitor**. Ele permite "separar" o algoritmo de exportação da estrutura dos objetos de relatório. 

* **Elementos (Relatórios):** Implementam uma interface com o método 'accept(Visitor)'. A responsabilidade do relatório é receber um visitante e passar a si mesmo como parâmetro.
* **Visitantes (Exportadores):** Implementam a lógica específica de exportação para cada tipo de relatório. 

Dessa forma, se precisarmos de um novo formato de saída no futuro (ex: .txt ou .csv), basta criar uma nova classe Visitor, sem alterar nenhuma linha de código dos relatórios existentes.

## Estrutura do Código

Toda a implementação foi centralizada no arquivo 'SistemaRelatorios.java', organizada da seguinte forma:

1. **Interfaces Base:** 'IVisitorExportacao' e 'IRelatorio'.
2. **Relatórios:** 'RelatorioTexto', 'RelatorioImagem' e 'RelatorioGrafico'.
3. **Exportadores (Visitors):** 'ExportadorHTML', 'ExportadorPlanilha' e 'ExportadorPDF'.
4. **Cliente:** A classe principal 'SistemaRelatorios' organiza a criação da lista de relatórios e aplica os visitantes.
