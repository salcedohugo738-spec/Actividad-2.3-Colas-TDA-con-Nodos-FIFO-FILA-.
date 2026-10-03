/*
Morales Escobar Juan Adrian
Salcedo Alvarez Hugo Emmanuel
 */
package back_end;

import java.time.LocalTime;
import java.util.Objects;


public class Pagina {
  private String url;
  private String titulo;
  private LocalTime hora;

    public Pagina(String url, String titulo, LocalTime hora) {
        this.url = url;
        this.titulo = titulo;
        this.hora = hora;
    }

    public Pagina() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pagina other = (Pagina) obj;
        return Objects.equals(this.url, other.url);
    }

    @Override
    public String toString() {
        return "Pagina{" + "url=" + url + ", titulo=" + titulo + ", hora=" + hora + '}';
    }
  
}
