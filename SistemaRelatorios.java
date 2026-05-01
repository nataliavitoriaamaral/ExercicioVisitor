interface IVisitorExportacao {
    void visitRelatorioTexto(RelatorioTexto relatorio);
    void visitRelatorioImagem(RelatorioImagem relatorio);
    void visitRelatorioGrafico(RelatorioGrafico relatorio);
}

interface IRelatorio {
    void accept(IVisitorExportacao visitor);
}

class RelatorioTexto implements IRelatorio {
    public String conteudo = "Texto do relatorio";
    public void accept(IVisitorExportacao visitor) {
        visitor.visitRelatorioTexto(this);
    }
}

class RelatorioImagem implements IRelatorio {
    public String nomeImagem = "foto.png";
    public void accept(IVisitorExportacao visitor) {
        visitor.visitRelatorioImagem(this);
    }
}

class RelatorioGrafico implements IRelatorio {
    public String dadosGrafico = "[100, 200, 500]";
    public void accept(IVisitorExportacao visitor) {
        visitor.visitRelatorioGrafico(this);
    }
}
