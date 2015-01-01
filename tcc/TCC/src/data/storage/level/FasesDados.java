package data.storage.level;

import util.Universal;

public class FasesDados {
    
    public static FasesDadosNode[] fase = new FasesDadosNode[Universal.quantidadeFases + 1];
    
    public static void initialize(){
        fase[0] = null;
        
        fase[1] = new FasesDadosNode(1, "Nessa fase não tem muitos problemas para o Proto enfrentar. Um comando de mover para a direita ja resolve. Proto irá executar o código a cada quadro. É importante que você leia a documentação para aprender todas as funcionalidades de Proto.", false);
        fase[2] = new FasesDadosNode(2, "Proto pode identificar o que tem em um quadro do cenário, escaneando uma posição(x, y). Desse modo, ele pode identificar quando tem um buraco no quadro à frente, por exemplo. Proto também é capaz de pular, driblando assim os buracos. Saiba mais sobre essas funcionalidades na documentação.", false);
        fase[3] = new FasesDadosNode(3, "Pratique pulos nas mais variadas ocasiões. Saia dessa fase fazendo Proto dominar a arte de pular. Vai ser importante para cenários mais complicados.", false);
        fase[4] = new FasesDadosNode(4, "É importante que Proto tenha inteligência para escolher o lado certo a seguir dependendo da fase. Use este cenário para praticar essa troca e escolha de sentido para onde ir. Tente pegar todas as esferas em ordem(1,2 e 3) e depois chegar ao objetivo. Olhe a documentação para aprender mais sobre os recursos de Proto.", false);
        fase[5] = new FasesDadosNode(5, "Proto pode identificar, subir, e descer escadas. Quando ele sobe, vai até o fim da escada. Ao descer, vai até o fim também. Veja a documentação para mais detalhes. É importante que você teste e treine neste cenário até dominar as escadas, pois será importante mais pra frente.\nDica: Proto tem problemas com escadas. Você deve achar um jeito de sair de perto da escada após subir/descer ela, ou então o robô pode ficar subindo e descendo sem parar.", false);
        fase[6] = new FasesDadosNode(6, "As escadas podem ser diferentes dependendo do tipo de cenário. Nesta fase por exemplo, ele usa rochas empilhadas como escada, o funcionamento é o mesmo. Use o que aprendeu sobre sentidos e escadas, e tente fazer uma boa pontuação.", false);
        fase[7] = new FasesDadosNode(7, "Neste momento, você ja está preparado para ajudar Proto em desafios maiores. Este cenário exige um pouco de tudo que você aprendeu e praticou: saber quando pular, quando pode cair, inteligência para escolher o sentido, subir e descer escadas, pegar esferas em sequência e chegar ao objetivo. Dê o seu melhor!", false);
       // fase[8] = new FasesDadosNode(8, "Esta fase não é oficial.", false);
        //fase[9] = new FasesDadosNode(9, "Esta fase não é oficial.", false);

    }
    
}
