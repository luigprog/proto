package data.storage.level;

import util.Universal;

public class FasesDados {
    
    public static FasesDadosNode[] fase = new FasesDadosNode[Universal.quantidadeFases + 1];
    
    public static void initialize(){
        fase[0] = null;
        
        fase[1] = new FasesDadosNode(1, "This level has no problems for Proto. A move command and it is done. All the code will be executed each square/movement, then you don't need more than 1 move command to win this level.", false);
        fase[2] = new FasesDadosNode(2, "Proto can scan any square in the stage. The method scan(x, y) returns information about a square in the stage. This way, Proto can know if there is a hole in front and he must jump, for example.", false);
        fase[3] = new FasesDadosNode(3, "There is an opportunity to practice jumps. Use the scan method and dominate the jumps, getting all 3 spheres and proving that you rock!", false);
        fase[4] = new FasesDadosNode(4, "Try to get all the spheres in order(1,2,3). Proto have functions to work with directions, and he also can know where is the 'next' sphere.", false);
        fase[5] = new FasesDadosNode(5, "Proto pode identificar, subir, e descer escadas. Quando ele sobe, vai até o fim da escada. Ao descer, vai até o fim também. Veja a documentação para mais detalhes. É importante que você teste e treine neste cenário até dominar as escadas, pois será importante mais pra frente.\nDica: Proto tem problemas com escadas. Você deve achar um jeito de sair de perto da escada após subir/descer ela, ou então o robô pode ficar subindo e descendo sem parar.", false);
        fase[6] = new FasesDadosNode(6, "As escadas podem ser diferentes dependendo do tipo de cenário. Nesta fase por exemplo, ele usa rochas empilhadas como escada, o funcionamento é o mesmo. Use o que aprendeu sobre sentidos e escadas, e tente fazer uma boa pontuação.", false);
        fase[7] = new FasesDadosNode(7, "Neste momento, você ja está preparado para ajudar Proto em desafios maiores. Este cenário exige um pouco de tudo que você aprendeu e praticou: saber quando pular, quando pode cair, inteligência para escolher o sentido, subir e descer escadas, pegar esferas em sequência e chegar ao objetivo. Dê o seu melhor!", false);
       // fase[8] = new FasesDadosNode(8, "Esta fase não é oficial.", false);
        //fase[9] = new FasesDadosNode(9, "Esta fase não é oficial.", false);

    }
    
}
