public class ProdutoBuilder {
        public static Produto criar() {
                return new Produto("Dolly Guaraná",
                        3.50,
                        "Bebida gaseificada aromatizada artificialmente com sabor de guaraná",
                        new QualquerCoisa("Qualquer Coisa", "Descrição de qualquer coisa"));
        }
}
