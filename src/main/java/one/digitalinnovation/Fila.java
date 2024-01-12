package one.digitalinnovation;

public class Fila<T> {
    private No<T> refEntradaFila;

    public Fila() {
        this.refEntradaFila = null;
    }

    public void enqueue(T object) {
        No novoNo = new No(object);
        novoNo.setRefNo(refEntradaFila);
        refEntradaFila = novoNo;
    }

    public T first() {
        if (!this.isEmpty()) {
            No primeiroNo = refEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = refEntradaFila;
            No noAuxiliar = refEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty() {
        return refEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refEntradaFila;
        if (refEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = null;
        }
        return stringRetorno;
    }
}
