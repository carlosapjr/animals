package animais;

import java.io.IOException;
import java.util.Random;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;


public class Jogo extends MIDlet implements CommandListener {
    
     List menu;
     Display display = Display.getDisplay(this);
     Command cmdOK = new Command("OK", Command.OK, 1);
     Command cmdProximo = new Command("Próximo",Command.OK,1);
     Command cmdVoltar = new Command("Voltar", Command.BACK, 1);
     Image[] animais;
     String [] nomes;
     int index = 0;
     ChoiceGroup cg;
     int animaisAcertados = 0;
     int score = animaisAcertados;
             

    public void startApp() {
        
        menu= new List ("Animals",List.IMPLICIT);
        menu.append("Novo jogo", null);
        menu.append("Recordes", null);
        menu.append("Ajuda", null);
        menu.append("Sobre", null);
        menu.append("Sair", null);
        menu.setCommandListener(this);
        display.setCurrent(menu);
        carregaAnimais();       
       
    }
    
    public void pauseApp() {
        
        
    }
    
    public void destroyApp(boolean unconditional) {
        
        
    }

    public void commandAction(Command c, Displayable d) {
   
            if(c== List.SELECT_COMMAND){
            int i = menu.getSelectedIndex();
            if (i == 0){
                index = 0;
                animaisAcertados = 0;
                novoJogo();
            } else if (i == 1){
                carregaScore();
            } else if (i == 2){
                carregaAjuda();
                
            } else if (i == 3){
                
                carregaInfo();
                
            } else if (i == 4){
            notifyDestroyed();
                }
            
            } else if (c == cmdOK){
                
                if(cg.getString(cg.getSelectedIndex()).equals(nomes[index])){
                animaisAcertados++;
                if (animaisAcertados > score)
                {
                     score = animaisAcertados;
                }
                Alert alert = new Alert ("Animals");
                alert.setString("Resposta Correta!");
                alert.setTimeout(Alert.FOREVER);
                alert.setType(AlertType.INFO);
                alert.addCommand(cmdProximo);
                alert.setCommandListener(this);
                display.setCurrent(alert);
            }else{
                Alert alert = new Alert ("Animals");
                alert.setString("Resposta Errada !");
                alert.setTimeout(Alert.FOREVER);
                alert.setType(AlertType.INFO);
                alert.addCommand(cmdProximo);
                alert.setCommandListener(this);
                display.setCurrent(alert);
              
                }
            }
             else if (c == cmdProximo){
            
                index++;
                if(index == nomes.length){
                    mostraResultado();
                
                } else {
                novoJogo();
                }
            
            } else if (c == cmdVoltar){
             display.setCurrent(menu);
            
            }
    }
         

    private void novoJogo() {
            
Form f = new Form ("Animals");
ImageItem ii = new ImageItem("",animais[index],Item.LAYOUT_CENTER,"");
f.append(ii);
cg = new ChoiceGroup ("", Choice.EXCLUSIVE);

cg.append("", null);
cg.append("",null);
cg.append("",null);



Random r = new Random();
int opcao = r.nextInt(3);
cg.set(opcao, nomes[index], null);

opcao ++ ;

if (opcao == 3)
    opcao = 0;

int nome2 = r.nextInt(16);
while (nome2 == index)
     nome2 = r.nextInt(16);


cg.set(opcao, nomes[nome2], null);

opcao ++ ;

if (opcao == 3)
    opcao = 0;

int nome3 = r.nextInt(16);
while (nome3 == index || nome3 == nome2)
     nome3 = r.nextInt(16);

cg.set(opcao, nomes[nome3], null);

f.append(cg);

f.addCommand(cmdOK);
f.setCommandListener(this);



display.setCurrent(f);
    }
    
            
    private void carregaAnimais() {
        try{
            
        animais = new Image[16];
        Image i0 = Image.createImage("/animais/aguia.jpg");
        Image i1 = Image.createImage("/animais/arara.jpg");
        Image i2 = Image.createImage("/animais/chimpanze.jpg");
        Image i3 = Image.createImage("/animais/elefante.jpg");
        Image i4 = Image.createImage("/animais/gorila.jpg");
        Image i5 = Image.createImage("/animais/jaguar.jpg");
        Image i6 = Image.createImage("/animais/koala.jpg");
        Image i7 = Image.createImage("/animais/leao.jpg");
        Image i8 = Image.createImage("/animais/leopardo.jpg");
        Image i9 = Image.createImage("/animais/lince.jpg");
        Image i10 = Image.createImage("/animais/lobo.jpg");
        Image i11 = Image.createImage("/animais/lontra.jpg");
        Image i12 = Image.createImage("/animais/ocelote.jpg");
        Image i13 = Image.createImage("/animais/ornitorrinco.jpg");
        Image i14 = Image.createImage("/animais/panda.jpg");
        Image i15 = Image.createImage("/animais/pandaVermelho.jpg");
        Image i16 = Image.createImage("/animais/puma.jpg");
        Image i17 = Image.createImage("/animais/rinoceronteJava.jpg");
        Image i18 = Image.createImage("/animais/rinoceronteNegro.jpg");
        Image i19 = Image.createImage("/animais/tartarugaMarinha.jpg");
        Image i20 = Image.createImage("/animais/tasmania.jpg");
        Image i21 = Image.createImage("/animais/urso.jpg");
        
        animais = new Image[]{i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10,i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21};
        nomes = new String[] { "Aguia Real", "Arara Azul", "Chimpanzé","Elefante",
            "Gorila da Montanha", "Jaguar", "Koala" ,"Leão", "Leopardo das Neves", "Lince Ibérico","Lobo Ibérico",
            "Lontra", "Ocelote","Ornitorrinco","Panda Gigante","Panda Vermelho","Puma", "Rinoceronte de Java",
        "Rinoceronte Negro", "Tartaruga Marinha", "Diabo da Tasmania", "Urso Pardo"};
    }
        
        catch (IOException ex){
            ex.printStackTrace();
            
        }
    }    

    private void mostraResultado() {
        
        Form f = new Form("Animals");
        if(animaisAcertados > 1){
        f.append("Voce acertou " + animaisAcertados + " animais.");
        f.addCommand(cmdVoltar);
        } else 
        f.append("Voce acertou " + animaisAcertados + " animais.");
        f.addCommand(cmdVoltar);
        f.setCommandListener(this);
        display.setCurrent(f);
    
    }

    private void carregaAjuda() {
        
        Form f = new Form("Animals");
        f.append("Este app desenvolvido visando testar o seu conhecimento para enquanto as espécies de animais que estão prestes a entrar em extinção. ");
        f.addCommand(cmdVoltar);
        f.setCommandListener(this);
        display.setCurrent(f);
        
        
    }

    private void carregaInfo() {
        
        Form f = new Form("Animals");
        f.append("App: Animals\nVersão: 1.0\nDesenvolvedor: Carlos Alberto\nContato:carlos.cj.alberto@gmail.com ");
        f.addCommand(cmdVoltar);
        f.setCommandListener(this);
        display.setCurrent(f);
        
    }

    private void carregaScore() {
        Form f = new Form("Animals");
        if (score == 1){
        f.append("Pontuação Máxima:\n\n" + score + " Animais");
        f.addCommand(cmdVoltar);
    } else
        f.append("Pontuação Máxima:\n\n" + score + " Animais");
        f.addCommand(cmdVoltar);
        f.setCommandListener(this);
        display.setCurrent(f);
    }
}