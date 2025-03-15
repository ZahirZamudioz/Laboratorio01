
public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    
    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquina1(c1);
        setEsquina2(c2);
    }
    
    public Coordenada getEsquina2() {
        return this.esquina2;
    }

    public void setEsquina1(Coordenada coo) {
        this.esquina1 = new Coordenada(coo);
    }
    
    public Coordenada getEsquina1() {
        return this.esquina1;
    }

    public void setEsquina2(Coordenada coo) {
        this.esquina2 = new Coordenada(coo);
    }
    
    public String toString() {
        return "(" + this.esquina2.toString() + ", " + this.esquina1.toString() + ")";
    }
    
    // Método para calcular el área del rectángulo
    public double calculoArea() {
        double ancho = Math.abs(esquina2.getX() - esquina1.getX());
        double alto = Math.abs(esquina2.getY() - esquina1.getY());
        return ancho * alto;
    }
}