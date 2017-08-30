package cn.xiaohu.customer.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthCode
 */
@WebServlet("/AuthCode")
public class AuthCode extends HttpServlet {
    private static final int WIDTH = 60;//������֤��ͼƬ���
    private static final int HEIGHT = 20;//������֤��ͼƬ�߶�
    private static final int LENGTH = 4;//������֤�볤��
    //������֤��������ֵ��ַ�
    private static final String str = "1234567890" +
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] chars = str.toCharArray();//���ַ����������з��������ȡ
    private static Random random = new Random();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		        //�������������ΪͼƬ
		        response.setContentType("image/jpeg");

		        //���ò����л���
		        response.setHeader("pragma", "no-cache");
		        response.setHeader("cache-control", "no-cache");
		        response.setHeader("expires", "0");

		        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);

		        //����
		        Graphics graphics = image.getGraphics();

		        //���ñ�����ɫ�����ƾ��α���
		        graphics.setColor(Color.WHITE);
		        graphics.fillRect(0, 0, WIDTH, HEIGHT);

		        //���ڼ�¼���ɵ���֤��
		        String code = null;

		        //������֤�벢����
		        for (int i = 0; i < LENGTH; i++) {
		            String c = "" + chars[random.nextInt(str.length())];
		            graphics.setColor(getColor());
		            graphics.drawString(c, 20 * i + 10, 18);
		            code += c;
		        }

		        //���ɸ��ŵ�
		        for (int i = 0; i < 50; i++) {
		            graphics.setColor(getColor());
		            graphics.drawOval(random.nextInt(60), random.nextInt(20), 1, 1);
		        }

		        //�����ɵ���֤�����session�У��Ա����У��
		        HttpSession session = request.getSession();
		        System.out.println("code==="+code);
		        session.setAttribute("code", code);

		        //����ͼƬ
		        graphics.dispose();

		        //��ͼƬ�����response��
		        ImageIO.write(image, "JPEG", response.getOutputStream());
		    }

		    //���������ɫ
		    private Color getColor() {
		        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
