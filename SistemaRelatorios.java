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

class ExportadorHTML implements IVisitorExportacao {
    public void visitRelatorioTexto(RelatorioTexto relatorio) {
        System.out.println("</> Exportando HTML do texto: <p>" + relatorio.conteudo + "</p>");
    }
    public void visitRelatorioImagem(RelatorioImagem relatorio) {
        System.out.println("</> Exportando HTML da imagem: <img src='" + relatorio.nomeImagem + "' />");
    }
    public void visitRelatorioGrafico(RelatorioGrafico relatorio) {
        System.out.println("</> Exportando HTML do gráfico: <div>" + relatorio.dadosGrafico + "</div>");
    }
}

class ExportadorPlanilha implements IVisitorExportacao {
    public void visitRelatorioTexto(RelatorioTexto relatorio) {
        System.out.println("Exportando Planilha: Celula A1 -> " + relatorio.conteudo);
    }
    public void visitRelatorioImagem(RelatorioImagem relatorio) {
        System.out.println("Exportando Planilha: Imagem " + relatorio.nomeImagem);
    }
    public void visitRelatorioGrafico(RelatorioGrafico relatorio) {
        System.out.println("Exportando Planilha: Tabela gerada com " + relatorio.dadosGrafico);
    }
}

class ExportadorPDF implements IVisitorExportacao {
    public void visitRelatorioTexto(RelatorioTexto relatorio) {
        System.out.println("Gerando PDF com: " + relatorio.conteudo);
    }
    public void visitRelatorioImagem(RelatorioImagem relatorio) {
        System.out.println("Renderizando " + relatorio.nomeImagem + " no PDF");
    }
    public void visitRelatorioGrafico(RelatorioGrafico relatorio) {
        System.out.println("Desenhando gráfico vetorial: " + relatorio.dadosGrafico);
    }
}
