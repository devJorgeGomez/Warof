public class Casillas {

    private boolean ocupadoBarco;
    private boolean tocado;

    public Casillas(boolean ocupadoBarco, boolean tocado) {
        this.ocupadoBarco = ocupadoBarco;
        this.tocado = tocado;
    }

    public boolean isOcupadoBarco() {
        return ocupadoBarco;
    }

    public void setOcupadoBarco(boolean ocupadoBarco) {
        this.ocupadoBarco = ocupadoBarco;
    }

    public boolean isTocado() {
        return tocado;
    }

    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }

}