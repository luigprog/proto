/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.ParseException;
import bsh.TargetError;
import javax.swing.JOptionPane;

/**
 *
 * @author Gamer
 */
public class Beanshell {

    /**
     * @param args the command line arguments
     */
    public static int luigi = 8;
    
    public static void main(String[] args) {
        Interpreter bsh = new Interpreter();
        int x = 10;
        
            Const.luigi += 1000;
            try {
                bsh.eval("import test.Beanshell;");
                bsh.set("nome", "Luigi");
                bsh.set("flag1", false);
                bsh.set("nome2", "Garcia");
                bsh.eval("System.out.println(Beanshell.luigi);");
                while(true){
                    
                    bsh.eval("if(!flag1){flag1 = true;System.out.println(nome);nome2 += 8 ;} else {System.out.println(nome2);}");
                }
                
                
            } catch (TargetError e) {
                // The script threw an exception
                Throwable t = e.getTarget();
                System.out.println("Script threw exception: " + t);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            } catch (EvalError e) {
                System.out.println(e.getMessage());
                // General Error evaluating script
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
    }
}
