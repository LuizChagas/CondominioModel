package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.model.Aluguel;
import br.edu.ifsul.model.Condominio;
import br.edu.ifsul.model.Locatario;
import br.edu.ifsul.model.Pessoa;
import br.edu.ifsul.model.Recurso;
import br.edu.ifsul.model.UnidadeCondominial;
import java.util.ArrayList;
import java.util.List;

public class FabricaObjetos {

    public static List<Condominio> carregaCondominios() {
        List<Condominio> lista = new ArrayList<>();

        Condominio c1 = new Condominio();
        c1.setNome("Condominio 1");
        c1.setNumero("1");
        c1.setCep("11111000");
        c1.setEndereco("Endereço 1");
        c1.setId(1);
        lista.add(c1);

        Condominio c2 = new Condominio();
        c2.setNome("Condominio 2");
        c2.setNumero("2");
        c2.setCep("22222000");
        c2.setEndereco("Endereço 2");
        c2.setId(2);
        lista.add(c2);

        Condominio c3 = new Condominio();
        c3.setNome("Condominio 3");
        c3.setNumero("3");
        c3.setCep("33333000");
        c3.setEndereco("Endereço 3");
        c3.setId(3);
        lista.add(c3);
        
        return lista;
    }
}
