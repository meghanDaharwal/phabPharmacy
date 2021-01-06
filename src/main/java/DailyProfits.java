import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.awt.Color.lightGray;
import static java.awt.Color.white;

public class DailyProfits {
    // Icons
    Icon home = new ImageIcon("Icons/home.png");
    Icon search = new ImageIcon("Icons/search.png");
    // Labels
    JLabel currentUserLabel = new JLabel("Logged in as: ");
    JLabel currentUser = new JLabel();
    JLabel branchNameLabel = new JLabel("Branch: ");
    JLabel branchName = new JLabel();

    JLabel dailyProfitLbl = new JLabel("Today's Daily Profit:");
    JLabel currencyGBP = new JLabel("GBP");
    JLabel dailyProfit = new JLabel("0.00");

    JLabel dateLbl = new JLabel("Date");
    JLabel date = new JLabel();
    JLabel profitOnDateLbl = new JLabel("Profit on Date");
    JLabel profitOnDate = new JLabel();

    JLabel dateForSearchLbl = new JLabel("Date (dd-mm-yyyy)");
    // Text fields
    JFormattedTextField dateTxtField = new JFormattedTextField();
    // Buttons
    JButton toDashboardPage = new JButton("Back to Home",home);
    JButton searchDate = new JButton(search);

    DailyProfits(){
// Initialising main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800,500));
        mainPanel.setLayout(null);

// Adding the back to home button
        JPanel backToHome = new JPanel();
        backToHome.setBackground(white);
        backToHome.setBounds(20,12,140,30);

        toDashboardPage.setPreferredSize(new Dimension(135,25));
        toDashboardPage.setBorderPainted(false);
        toDashboardPage.setFocusPainted(false);
        toDashboardPage.setContentAreaFilled(true);
        toDashboardPage.setBackground(lightGray);

        backToHome.add(toDashboardPage);
        mainPanel.add(backToHome);

// Current User Details
        JPanel crrntUserDet = new JPanel();
        crrntUserDet.setLayout(new GridLayout(2,2));
        crrntUserDet.setBounds(580,10,180,30);
        crrntUserDet.setBackground(white);

        JLabel[] crrntUserDetLbl = {currentUserLabel,branchNameLabel};
        JLabel[] crrntUserDetName = {currentUser,branchName};

        for(int i=0;i<crrntUserDetLbl.length;i++){
            crrntUserDetLbl[i].setFont(new Font(null,Font.BOLD,10));
            crrntUserDetLbl[i].setForeground(new Color(51,171,240));
            crrntUserDetName[i].setFont(new Font(null,Font.PLAIN,10));
            crrntUserDetName[i].setForeground(new Color(92,180,68));
            crrntUserDet.add(crrntUserDetLbl[i]);
            crrntUserDet.add(crrntUserDetName[i]);
        }

        mainPanel.add(crrntUserDet);

// Today's daily profit panel
        JPanel dailyProfitPnl = new JPanel();
        dailyProfitPnl.setBackground(white);
        dailyProfitPnl.setBounds(95,100,600,70);

        currencyGBP.setFont(new Font(null,Font.BOLD,39));
        currencyGBP.setForeground(new Color(118,27,38));
        dailyProfitLbl.setFont(new Font(null,Font.BOLD,40));
        dailyProfitLbl.setForeground(new Color(54,58,101));
        dailyProfit.setFont(new Font(null,Font.BOLD,40));
        dailyProfit.setForeground(new Color(118,27,38));

        dailyProfitPnl.add(dailyProfitLbl);
        dailyProfitPnl.add(currencyGBP);
        dailyProfitPnl.add(dailyProfit);

        mainPanel.add(dailyProfitPnl);

// Search previous dates
        JPanel datesSrchPnl = new JPanel();
        datesSrchPnl.setBackground(white);

        Border titBorderCodeSrch = BorderFactory.createTitledBorder(null,"Search Date for Profit",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font(null,Font.BOLD,14));
        datesSrchPnl.setBorder(new CompoundBorder(titBorderCodeSrch,new EmptyBorder(0,0,0,0)));
        datesSrchPnl.setVisible(true);
        datesSrchPnl.setBounds(235,175,330,70);

        searchDate.setBorderPainted(false);
        searchDate.setFocusPainted(false);
        searchDate.setContentAreaFilled(true);
        searchDate.setBackground(Color.lightGray);

        try {
            String inputMask = "HH-HH-HHHH";
            dateTxtField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(inputMask)));
        } catch (ParseException ex){
        }

        searchDate.setPreferredSize(new Dimension(25,25));
        dateTxtField.setPreferredSize(new Dimension(160,25));

        datesSrchPnl.add(dateForSearchLbl);
        datesSrchPnl.add(dateTxtField);
        datesSrchPnl.add(searchDate);

        mainPanel.add(datesSrchPnl);

// Previous Profits
        JPanel previousProfits = new JPanel();
        previousProfits.setBackground(white);
        Border titBorderProdDet = BorderFactory.createTitledBorder(null,"Profits from Particular Date", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,new Font(null,Font.BOLD,14));

        JLabel[] profitOnDateLabels = {dateLbl,profitOnDateLbl};
        JLabel[] profitOnDateVals = {date,profitOnDate};
        for(int i=0; i<profitOnDateLabels.length; i++){
            profitOnDateLabels[i].setFont(new Font("Arial",Font.BOLD,12));
            profitOnDateVals[i].setFont(new Font("Arial",Font.PLAIN,12));
        }

        previousProfits.setLayout(new GridLayout(2,2));
        previousProfits.setBorder(new CompoundBorder(titBorderProdDet,new EmptyBorder(2,10,2,10)));
        previousProfits.setVisible(true);
        previousProfits.setBounds(235,260,330,70);

        for(int i=0; i<profitOnDateLabels.length; i++){
            previousProfits.add(profitOnDateLabels[i]);
            previousProfits.add(profitOnDateVals[i]);
        }

        mainPanel.add(previousProfits);

// Initialising frame
        JFrame frame = new JFrame("Phab Pharmacies - Find in Store");
        frame.setSize(800,530);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        mainPanel.setBackground(white);
        frame.setBackground(white);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setResizable(false);

// Add servlet connection here
        searchDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setText(dateTxtField.getText());
            }
        });

// Back to home button
        toDashboardPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.currentUser.setText(currentUser.getText());
                dashboardPage.branchName.setText(branchName.getText());
                frame.setVisible(false);
            }
        });
    }
}
