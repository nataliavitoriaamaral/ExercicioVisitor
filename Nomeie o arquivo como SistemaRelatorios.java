interface IVisitorExportacao {
    void visitRelatorioTexto(RelatorioTexto relatorio);
    void visitRelatorioImagem(RelatorioImagem relatorio);
    void visitRelatorioGrafico(RelatorioGrafico relatorio);
}

interface IRelatorio {
    void accept(IVisitorExportacao visitor);
}
