package padroescriacao.unificado.abstractfactory;

public class AntivirusBasico implements IAntivirus {

    @Override
    public String ativar() {
        return "Antivírus Básico";
    }
}