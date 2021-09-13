import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class ProdutoBuilder {
        public static Produto criar() {
                boolean useLetters = true;
                boolean useNumbers = false;
                String descricao = RandomStringUtils.random(10, useLetters, useNumbers);
                String nome = RandomStringUtils.random(5, useLetters, useNumbers);
                float generatedFloat = 1F + new Random().nextFloat() * (10F - 1F);
                return new Produto(nome, (double) generatedFloat, descricao, new QualquerCoisa(nome, descricao));
        }
}
