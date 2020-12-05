package JavaProject;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
 
class Members extends JFrame implements ActionListener{
    
    JPanel panel;
    JLabel lblid, lblpw, lblname, lblemail, lbladdr;
    JButton b1, b2;
    JTextField txtid, txtpw, txtname, txtemail, txtaddr;
    
    Members(){
        setTitle("회원가입");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        
        lblid = new JLabel("ID");
        lblpw = new JLabel("PW");
        lblname = new JLabel("NAME");
        lblemail = new JLabel("EMAIL");
        lbladdr = new JLabel("ADDR");
        
        txtid = new JTextField(10);
        txtpw = new JTextField(10);
        txtname = new JTextField(10);
        txtemail = new JTextField(20);
        txtaddr = new JTextField(30);
        
        b1 = new JButton("가입");
        b2 = new JButton("취소");
        
        panel.add(lblid);
        panel.add(txtid);
        panel.add(lblpw);
        panel.add(txtpw);
        panel.add(lblname);
        panel.add(txtname);
        panel.add(lblemail);
        panel.add(txtemail);
        panel.add(lbladdr);
        panel.add(txtaddr);
        panel.add(b1);
        panel.add(b2);
        
        add(panel);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent e) {
            try{
                String s = null;
                boolean isOk = false;
                BufferedWriter bw = new BufferedWriter(new FileWriter("members.txt", true));
                BufferedReader br = new BufferedReader(new FileReader("members.txt"));
                
                
                if(e.getSource() == b1) {
                    while((s = br.readLine()) != null) {
                        
                        // 아이디 중복
                        String[] array = s.split("/");
                        if(array[0].equals(txtid.getText())){
                                isOk = true;
                                break;
                        }
                    }
                            //정보 입력시 중복이 없으면 데이터 보냄
                            if(!isOk) {
                            bw.write(txtid.getText() + "/");
                            bw.write(txtpw.getText() + "/");
                            bw.write(txtname.getText() + "/");
                            bw.write(txtemail.getText() + "/");
                            bw.write(txtaddr.getText() + "\r\n");
                            bw.close();
 
                            JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
                            dispose();
                            }else {
                                JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
                            }
                    
                }else if(e.getSource() == b2) {
                    txtid.setText("");
                    txtpw.setText("");
                    txtname.setText("");
                    txtemail.setText("");
                    txtaddr.setText("");
                }
            }catch (IOException  ex){
                JOptionPane.showMessageDialog(null, "실패");
            }
        }
        
    public static void main(String[] args) {
        new Members();
    }
}