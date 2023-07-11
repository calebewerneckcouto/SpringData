import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class SelectBoxExample extends JFrame {
    private JComboBox<String> fabricanteComboBox;
    private JComboBox<String> maquinaComboBox;
    private JComboBox<String> pastaComboBox;
    private JComboBox<String> chipsetComboBox;
    private JComboBox<String> placasComboBox;
    private JComboBox<String> portaserialComboBox;
    private JComboBox<String> baudrateComboBox;
    
    
    
    private JTextArea outputTextArea;

    private JButton copiarButton;
    private JButton compilarButton;

    private List<String> fabricantes;
    private List<String> maquinas;
    private List<String> pastas;
    private String selectedChipset;
    private String selectedPlacas;
    private String selectedPortaSerial;
    private String selectedbaudrate;

    public SelectBoxExample() throws IOException {
    	
    	 // Configuração inicial
        setTitle("Montar Firmware");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 380);
        setLayout(new FlowLayout());

        // Inicialização das listas
        fabricantes = new ArrayList<>();
        maquinas = new ArrayList<>();
        pastas = new ArrayList<>();

        // Criar select box do fabricante
        fabricanteComboBox = new JComboBox<>();
        fabricanteComboBox.setPreferredSize(new Dimension(200, 25));
        fabricanteComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarMaquinas();
            }
        });
     // Criar select box do fabricante
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        fabricanteComboBox = new JComboBox<>();
        fabricanteComboBox.setPreferredSize(new Dimension(200, 25));
        fabricanteComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarMaquinas();
            }
        });
        add(fabricanteLabel);
        add(fabricanteComboBox);


        // Criar select box das máquinas
        JLabel maquinaLabel = new JLabel("Máquinas:");
        maquinaComboBox = new JComboBox<>();
        maquinaComboBox.setPreferredSize(new Dimension(200, 25));
        maquinaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarPastas();
            }
        });
        add(maquinaLabel);
        add(maquinaComboBox);

        // Criar select box das pastas
        JLabel pastaLabel = new JLabel("Pastas:");
        pastaComboBox = new JComboBox<>();
        pastaComboBox.setPreferredSize(new Dimension(200, 25));
        add(pastaLabel);
        add(pastaComboBox);

        // Criar select box do chipset
        JLabel chipsetLabel = new JLabel("Chipset:");
        chipsetComboBox = new JComboBox<>();
        chipsetComboBox.setPreferredSize(new Dimension(200, 25));
        add(chipsetLabel);
        add(chipsetComboBox);

        // Preencher a select box do chipset
        String[] chipsetOptions = {
            "(Selecione o chipset)",
            "Anet_ET4_OpenBLT",
            "ARMED",
            "at90usb1286_cdc",
            "at90usb1286_dfu",
            "BIGTREE_SKR_PRO",
            "BIGTREE_SKR_PRO_usb_flash_drive",
            "BIGTREE_BTT002",
            "BIGTREE_E3_RRF",
            "BIGTREE_SKR_2",
            "BIGTREE_SKR_2_USB",
            "BIGTREE_SKR_2",
            "BIGTREE_SKR_2_USB",
            "BIGTREE_GTR_V1_0",
            "BIGTREE_GTR_V1_0_usb_flash_drive",
            "BIGTREE_OCTOPUS_V1",
            "BIGTREE_OCTOPUS_V1_USB",
            "BTT_SKR_SE_BX",
            "chitu_f103",
            "chitu_v5_gpio_init",
            "custom",
            "DUE",
            "DUE_USB",
            "DUE_debug",
            "DUE_archim",
            "DUE_archim_debug",
            "esp32",
            "flsun_hispeedv1",
            "FLY_MINI",
            "FLY_MINI_maple",
            "FLYF407ZG",
            "FYSETC_CHEETAH_V20",
            "FYSETC_E4",
            "FYSETC_F6",
            "FYSETC_S6",
            "FYSETC_S6_8000",
            "jgaurora_a5s_a1",
            "LERDGEK",
            "LERDGEK_usb_flash_drive",
            "linux_native",
            "LPC1768",
            "LPC1769",
            "malyan_M300",
            "mega1280",
            "mega2560",
            "mega2560ext",
            "melzi_optiboot_optimized",
            "melzi_optiboot",
            "melzi_optimized",
            "melzi",
            "mks_robin",
            "mks_robin_e3",
            "mks_robin_e3_maple",
            "mks_robin_e3p",
            "mks_robin_lite",
            "mks_robin_lite3",
            "mks_robin_maple",
            "mks_robin_mini",
            "mks_robin_nano35",
            "mks_robin_nano35_maple",
            "mks_robin_nano_v3",
            "mks_robin_nano_v3_usb_flash_drive",
            "mks_robin_nano_v3_usb_flash_drive_msc",
            "mks_robin_pro",
            "mks_robin_pro2",
            "MKS_ROBIN2",
            "MightyBoard1280",
            "MightyBoard2560",
            "mingda_mpx_arm_mini",
            "NUCLEO_F767ZI",
            "rambo",
            "REMRAM_V1",
            "rumba32",
            "SAMD51_grandcentral_m4",
            "sanguino1284p_optimized",
            "sanguino1284p",
            "sanguino644p",
            "STM32F070CB_malyan",
            "STM32F070RB_malyan",
            "STM32F103CB_malyan_maple",
            "STM32F103RC_btt",
            "STM32F103RC_btt_maple",
            "STM32F103RC_btt_USB",
            "STM32F103RC_btt_USB_maple",
            "STM32F103RC_fysetc",
            "STM32F103RC_meeb",
            "STM32F103RE",
            "STM32F103RE_btt",
            "STM32F103RE_btt_maple",
            "STM32F103RE_btt_USB",
            "STM32F103RE_btt_USB_maple",
            "STM32F103RE_maple",
            "STM32F103RET6_creality",
            "STM32F103RET6_creality_maple",
            "STM32F103VE",
            "STM32F103VE_longer",
            "STM32F401VE_STEVAL",
            "STM32F407VE_black",
            "teensy31",
            "teensy35",
            "teensy36",
            "teensy41",
            "trigorilla_pro"

            // Resto das opções do chipset
        };

        for (String option : chipsetOptions) {
            chipsetComboBox.addItem(option);
        }
        
        

        // Criar select box do chipset
        JLabel baudrateLabel = new JLabel("Baudrate:");
        baudrateComboBox = new JComboBox<>();
        baudrateComboBox.setPreferredSize(new Dimension(200, 25));
        add(baudrateLabel);
        add(baudrateComboBox);

        // Preencher a select box do chipset
        String[] baudrateOptions = {
            "(Selecione o Baudrate)",
            "2400",
            "9600",
            "19200",
            "38400",
            "57600",
            "115200",
            "250000",
            "500000",
            "1000000"

            // Resto das opções do chipset
        };

        for (String option : baudrateOptions) {
        	baudrateComboBox.addItem(option);
        }
        
        
        
        
        
        
      
      
        portaserialComboBox = new JComboBox<>();

        JLabel portaserialLabel = new JLabel("Porta Serial:");

        portaserialComboBox.setPreferredSize(new Dimension(200, 25));
        add(portaserialLabel);
        add(portaserialComboBox);

        // Preencher a select box do chipset
        String[] serialOptions = {
                "(Selecione a porta serial)",
                "-2",
                "-1",
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7"
        };

        for (String option : serialOptions) {
            portaserialComboBox.addItem(option);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
        
        
        
    
        
        
        JLabel placasLabel = new JLabel("Placas:");
        placasComboBox = new JComboBox<>();
        placasComboBox.setPreferredSize(new Dimension(550, 25));

 
        add(placasLabel);
        add(placasComboBox);

        pack();
        setVisible(true);

        // Preencher a select box do chipset
        String[] placasOptions = {
        		"BOARD_RAMPS_OLD",
        		"BOARD_RAMPS_13_EFB",
        		"BOARD_RAMPS_13_EEB",
        		"BOARD_RAMPS_13_EFF",
        		"BOARD_RAMPS_13_EEF",
        		"BOARD_RAMPS_13_SF",
        		"BOARD_RAMPS_14_EFB",
        		"BOARD_RAMPS_14_EEB",
        		"BOARD_RAMPS_14_EFF",
        		"BOARD_RAMPS_14_EEF",
        		"BOARD_RAMPS_14_SF",
        		"BOARD_RAMPS_PLUS_EFB",
        		"BOARD_RAMPS_PLUS_EEB",
        		"BOARD_RAMPS_PLUS_EFF",
        		"BOARD_RAMPS_PLUS_EEF",
        		"BOARD_RAMPS_PLUS_SF",
        		"BOARD_3DRAG",
        		"BOARD_K8200",
        		"BOARD_K8400",
        		"BOARD_K8600",
        		"BOARD_K8800",
        		"BOARD_BAM_DICE",
        		"BOARD_BAM_DICE_DUE",
        		"BOARD_MKS_BASE",
        		"BOARD_MKS_BASE_14",
        		"BOARD_MKS_BASE_15",
        		"BOARD_MKS_BASE_16",
        		"BOARD_MKS_BASE_HEROIC",
        		"BOARD_MKS_GEN_13",
        		"BOARD_MKS_GEN_L",
        		"BOARD_KFB_2",
        		"BOARD_ZRIB_V20",
        		"BOARD_ZRIB_V52",
        		"BOARD_FELIX2",
        		"BOARD_RIGIDBOARD",
        		"BOARD_RIGIDBOARD_V2",
        		"BOARD_SAINSMART_2IN1",
        		"BOARD_ULTIMAKER",
        		"BOARD_ULTIMAKER_OLD",
        		"BOARD_AZTEEG_X3",
        		"BOARD_AZTEEG_X3_PRO",
        		"BOARD_ULTIMAIN_2",
        		"BOARD_RUMBA",
        		"BOARD_RUMBA_RAISE3D",
        		"BOARD_RL200",
        		"BOARD_FORMBOT_TREX2PLUS",
        		"BOARD_FORMBOT_TREX3",
        		"BOARD_FORMBOT_RAPTOR",
        		"BOARD_FORMBOT_RAPTOR2",
        		"BOARD_BQ_ZUM_MEGA_3D",
        		"BOARD_MAKEBOARD_MINI",
        		"BOARD_TRIGORILLA_13",
        		"BOARD_TRIGORILLA_14",
        		"BOARD_TRIGORILLA_14_11",
        		"BOARD_RAMPS_ENDER_4",
        		"BOARD_RAMPS_CREALITY",
        		"BOARD_DAGOMA_F5",
        		"BOARD_FYSETC_F6_13",
        		"BOARD_FYSETC_F6_14",
        		"BOARD_DUPLICATOR_I3_PLUS",
        		"BOARD_VORON",
        		"BOARD_TRONXY_V3_1_0",
        		"BOARD_Z_BOLT_X_SERIES",
        		"BOARD_TT_OSCAR",
        		"BOARD_OVERLORD",
        		"BOARD_HJC2560C_REV1",
        		"BOARD_HJC2560C_REV2",
        		"BOARD_TANGO",
        		"BOARD_MKS_GEN_L_V2",
        		"BOARD_MKS_GEN_L_V21",
        		"BOARD_COPYMASTER_3D",
        		"BOARD_ORTUR_4",
        		"BOARD_TENLOG_D3_HERO",
        		"BOARD_RAMPS_S_12_EEFB",
        		"BOARD_RAMPS_S_12_EEEB",
        		"BOARD_RAMPS_S_12_EFFB",
        		"BOARD_LONGER3D_LK1_PRO",
        		"BOARD_LONGER3D_LKx_PRO",
        		"BOARD_ZRIB_V53",
        		"BOARD_PXMALION_CORE_I3",
        		"BOARD_RAMBO",
        		"BOARD_MINIRAMBO",
        		"BOARD_MINIRAMBO_10A",
        		"BOARD_EINSY_RAMBO",
        		"BOARD_EINSY_RETRO",
        		"BOARD_SCOOVO_X9H",
        		"BOARD_RAMBO_THINKERV2",
        		"BOARD_CNCONTROLS_11",
        		"BOARD_CNCONTROLS_12",
        		"BOARD_CNCONTROLS_15",
        		"BOARD_CHEAPTRONIC",
        		"BOARD_CHEAPTRONIC_V2",
        		"BOARD_MIGHTYBOARD_REVE",
        		"BOARD_MEGATRONICS",
        		"BOARD_MEGATRONICS_2",
        		"BOARD_MEGATRONICS_3",
        		"BOARD_MEGATRONICS_31",
        		"BOARD_MEGATRONICS_32",
        		"BOARD_ELEFU_3",
        		"BOARD_LEAPFROG",
        		"BOARD_MEGACONTROLLER",
        		"BOARD_GT2560_REV_A",
        		"BOARD_GT2560_REV_A_PLUS",
        		"BOARD_GT2560_REV_B",
        		"BOARD_GT2560_V3",
        		"BOARD_GT2560_V4",
        		"BOARD_GT2560_V3_MC2",
        		"BOARD_GT2560_V3_A20",
        		"BOARD_EINSTART_S",
        		"BOARD_WANHAO_ONEPLUS",
        		"BOARD_LEAPFROG_XEED2015",
        		"BOARD_PICA_REVB",
        		"BOARD_PICA",
        		"BOARD_INTAMSYS40",
        		"BOARD_MALYAN_M180",
        		"BOARD_GT2560_V4_A20",
        		"BOARD_PROTONEER_CNC_SHIELD_V3",
        		"BOARD_WEEDO_62A",
        		"BOARD_MINITRONICS",
        		"BOARD_SILVER_GATE",
        		"BOARD_SANGUINOLOLU_11",
        		"BOARD_SANGUINOLOLU_12",
        		"BOARD_MELZI",
        		"BOARD_MELZI_V2",
        		"BOARD_MELZI_MAKR3D",
        		"BOARD_MELZI_CREALITY",
        		"BOARD_MELZI_MALYAN",
        		"BOARD_MELZI_TRONXY",
        		"BOARD_STB_11",
        		"BOARD_AZTEEG_X1",
        		"BOARD_ANET_10",
        		"BOARD_ZMIB_V2",
        		"BOARD_GEN3_MONOLITHIC",
        		"BOARD_GEN3_PLUS",
        		"BOARD_GEN6",
        		"BOARD_GEN6_DELUXE",
        		"BOARD_GEN7_CUSTOM",
        		"BOARD_GEN7_12",
        		"BOARD_GEN7_13",
        		"BOARD_GEN7_14",
        		"BOARD_OMCA_A", 
        		
        		 "BOARD_OMCA",                   
        		 "BOARD_SETHI",                   

        		

        		 "BOARD_TEENSYLU",              
        		 "BOARD_PRINTRBOARD",                   		
        		 "BOARD_PRINTRBOARD_REVF",     
        		 "BOARD_BRAINWAVE",               
        		 "BOARD_BRAINWAVE_PRO",           
        		 "BOARD_SAV_MKI",                 
        		 "BOARD_TEENSY2",               
        		 "BOARD_5DPRINT",                 
        	

        		 "BOARD_RAMPS_14_RE_ARM_EFB",    
        		 "BOARD_RAMPS_14_RE_ARM_EEB",     
        		 "BOARD_RAMPS_14_RE_ARM_EFF",     
        		 "BOARD_RAMPS_14_RE_ARM_EEF",     
        		 "BOARD_RAMPS_14_RE_ARM_SF",     
        		 "BOARD_MKS_SBASE",               
        		 "BOARD_AZSMZ_MINI",              
        		 "BOARD_BIQU_BQ111_A4",           
        		 "BOARD_SELENA_COMPACT",          
        		 "BOARD_BIQU_B300_V1_0",          
        		 "BOARD_MKS_SGEN_L",              
        		 "BOARD_GMARSH_X6_REV1",          
        		 "BOARD_BTT_SKR_V1_1",            
        		 "BOARD_BTT_SKR_V1_3",            
        		 "BOARD_BTT_SKR_V1_4",            
        		 "BOARD_EMOTRONIC",               

        		

        		 "BOARD_MKS_SGEN",                
        		 "BOARD_AZTEEG_X5_GT",            
        		 "BOARD_AZTEEG_X5_MINI",          
        		 "BOARD_AZTEEG_X5_MINI_WIFI",     
        		 "BOARD_COHESION3D_REMIX",        
        		 "BOARD_COHESION3D_MINI",         
        		 "BOARD_SMOOTHIEBOARD",           
        		 "BOARD_TH3D_EZBOARD",            
        		 "BOARD_BTT_SKR_V1_4_TURBO",      
        		 "BOARD_MKS_SGEN_L_V2",           
        		 "BOARD_BTT_SKR_E3_TURBO",        
        		 "BOARD_FLY_CDY",                 

        	

        		 "BOARD_DUE3DOM",                 
        		 "BOARD_DUE3DOM_MINI",            
        		 "BOARD_RADDS",                   
        		 "BOARD_RAMPS_FD_V1",             
        		 "BOARD_RAMPS_FD_V2",             
        		 "BOARD_RAMPS_SMART_EFB",        
        		 "BOARD_RAMPS_SMART_EEB",         
        		 "BOARD_RAMPS_SMART_EFF",         
        		 "BOARD_RAMPS_SMART_EEF",         
        		 "BOARD_RAMPS_SMART_SF",          
        		 "BOARD_RAMPS_DUO_EFB",          
        		 "BOARD_RAMPS_DUO_EEB",           
        		 "BOARD_RAMPS_DUO_EFF",           
        		        
        		 "BOARD_RAMPS_DUO_SF",            
        		 "BOARD_RAMPS4DUE_EFB",           
        		 "BOARD_RAMPS4DUE_EEB",           
        		 "BOARD_RAMPS4DUE_EFF",          
        		 "BOARD_RAMPS4DUE_EEF",           
        		 "BOARD_RAMPS4DUE_SF",            
        		 "BOARD_RURAMPS4D_11",            
        		 "BOARD_RURAMPS4D_13",            
        		 "BOARD_ULTRATRONICS_PRO",        
        		 "BOARD_ARCHIM1",                 
        		 "BOARD_ARCHIM2",                 
        		 "BOARD_ALLIGATOR",               
        		 "BOARD_CNCONTROLS_15D",          
        		 "BOARD_KRATOS32",               

        	
        		 "BOARD_PRINTRBOARD_G2",         
        		 "BOARD_ADSK",                   

        	

        		 "BOARD_MALYAN_M200_V2",          
        		 "BOARD_MALYAN_M300",             
        		 "BOARD_STM32F103RE",             
        		 "BOARD_MALYAN_M200",             
        		 "BOARD_STM3R_MINI",              
        		 "BOARD_GTM32_PRO_VB",            
        		 "BOARD_GTM32_MINI",              
        		 "BOARD_GTM32_MINI_A30",          
        		 "BOARD_GTM32_REV_B",             
        		 "BOARD_MORPHEUS",                
        		 "BOARD_CHITU3D",                 
        		 "BOARD_MKS_ROBIN",               
        		 "BOARD_MKS_ROBIN_MINI",          
        		 "BOARD_MKS_ROBIN_NANO",          
        		 "BOARD_MKS_ROBIN_NANO_V2",       
        		 "BOARD_MKS_ROBIN_LITE",          
        		 "BOARD_MKS_ROBIN_LITE3",         
        		 "BOARD_MKS_ROBIN_PRO",           
        		 "BOARD_MKS_ROBIN_E3",            
        		 "BOARD_MKS_ROBIN_E3_V1_1",      
        		 "BOARD_MKS_ROBIN_E3D",           
        		 "BOARD_MKS_ROBIN_E3D_V1_1",      
        		 "BOARD_MKS_ROBIN_E3P",           
        		 "BOARD_BTT_SKR_MINI_V1_1",       
        		 "BOARD_BTT_SKR_MINI_E3_V1_0",    
        		 "BOARD_BTT_SKR_MINI_E3_V1_2",    
        		 "BOARD_BTT_SKR_MINI_E3_V2_0",    
        		 "BOARD_BTT_SKR_MINI_E3_V3_0",    
        		 "BOARD_BTT_SKR_MINI_MZ_V1_0",    
        		 "BOARD_BTT_SKR_E3_DIP",          
        		 "BOARD_BTT_SKR_CR6",             
        		 "BOARD_JGAURORA_A5S_A1",         
        		 "BOARD_FYSETC_AIO_II",           
        		 "BOARD_FYSETC_CHEETAH",          
        		 "BOARD_FYSETC_CHEETAH_V12",     
        		 "BOARD_LONGER3D_LK",             
        		 "BOARD_CCROBOT_MEEB_3DP",        
        		 "BOARD_CHITU3D_V5",              
        		 "BOARD_CHITU3D_V6",              
        		 "BOARD_CHITU3D_V9",              
        		 "BOARD_CREALITY_V4",             
        		 "BOARD_CREALITY_V422",           
        		 "BOARD_CREALITY_V423",           
        		 "BOARD_CREALITY_V425",           
        		 "BOARD_CREALITY_V427",           
        		 "BOARD_CREALITY_V4210",          
        		 "BOARD_CREALITY_V431",           
        		 "BOARD_CREALITY_V431_A",         
        		 "BOARD_CREALITY_V431_B",         
        		 "BOARD_CREALITY_V431_C",         
        		 "BOARD_CREALITY_V431_D",         
        		 "BOARD_CREALITY_V452",           
        		 "BOARD_CREALITY_V453",           
        		 "BOARD_CREALITY_V24S1",          
        		 "BOARD_CREALITY_V24S1_301",      
        		 "BOARD_CREALITY_V25S1",          
        		 "BOARD_TRIGORILLA_PRO",          
        		 "BOARD_FLY_MINI",                
        		 "BOARD_FLSUN_HISPEED",           
        		 "BOARD_BEAST",                   
        		 "BOARD_MINGDA_MPX_ARM_MINI",     
        		 "BOARD_GTM32_PRO_VD",            
        		 "BOARD_ZONESTAR_ZM3E2",          
        		 "BOARD_ZONESTAR_ZM3E4",          
        		 "BOARD_ZONESTAR_ZM3E4V2",        
        		 "BOARD_ERYONE_ERY32_MINI",       
        		 "BOARD_PANDA_PI_V29",            

        	
        		 "BOARD_TEENSY31_32",            
        		 "BOARD_TEENSY35_36",            

        		

        		 "BOARD_ARMED",                   
        		 "BOARD_RUMBA32_V1_0",            
        		 "BOARD_RUMBA32_V1_1",            
        		 "BOARD_RUMBA32_MKS",             
        		 "BOARD_RUMBA32_BTT",             
        		 "BOARD_BLACK_STM32F407VE",       
        		 "BOARD_BLACK_STM32F407ZE",       
        		 "BOARD_STEVAL_3DP001V1",         
        		 "BOARD_BTT_SKR_PRO_V1_1",        
        		 "BOARD_BTT_SKR_PRO_V1_2",        
        		 "BOARD_BTT_BTT002_V1_0",         
        		 "BOARD_BTT_E3_RRF",              
        		 "BOARD_BTT_SKR_V2_0_REV_A",      
        		 "BOARD_BTT_SKR_V2_0_REV_B",      
        		 "BOARD_BTT_GTR_V1_0",            
        		 "BOARD_BTT_OCTOPUS_V1_0",        
        		 "BOARD_BTT_OCTOPUS_V1_1",        
        		 "BOARD_BTT_OCTOPUS_PRO_V1_0",    
        		 "BOARD_LERDGE_K",                
        		 "BOARD_LERDGE_S",                
        		 "BOARD_LERDGE_X",                
        		 "BOARD_VAKE403D",               
        		 "BOARD_FYSETC_S6",               
        		 "BOARD_FYSETC_S6_V2_0",          
        		 "BOARD_FYSETC_SPIDER",           
        		 "BOARD_FLYF407ZG",               
        		 "BOARD_MKS_ROBIN2",              
        		 "BOARD_MKS_ROBIN_PRO_V2",        
        		 "BOARD_MKS_ROBIN_NANO_V3",     
        		 "BOARD_MKS_ROBIN_NANO_V3_1",     
        		 "BOARD_MKS_MONSTER8_V1",         
        		 "BOARD_MKS_MONSTER8_V2",         
        		 "BOARD_ANET_ET4",                
        		 "BOARD_ANET_ET4P",               
        		 "BOARD_FYSETC_CHEETAH_V20",      
        		 "BOARD_TH3D_EZBOARD_V2",        
        		 "BOARD_OPULO_LUMEN_REV3",        
        		 "BOARD_MKS_ROBIN_NANO_V1_3_F4",  
        		 "BOARD_MKS_EAGLE",              
        		 "BOARD_ARTILLERY_RUBY",         
        		 "BOARD_FYSETC_SPIDER_V2_2",     
        		 "BOARD_CREALITY_V24S1_301F4",   

        	
        		 "BOARD_REMRAM_V1",               
        		 "BOARD_TEENSY41",                
        		 "BOARD_T41U5XBB",                
        		 "BOARD_NUCLEO_F767ZI",        
        		 "BOARD_BTT_SKR_SE_BX_V2",        
        		 "BOARD_BTT_SKR_SE_BX_V3",        
        		 "BOARD_BTT_SKR_V3_0",            
        		 "BOARD_BTT_SKR_V3_0_EZ",         

        	
        		 "BOARD_ESPRESSIF_ESP32",         
        		 "BOARD_MRR_ESPA",                
        		 "BOARD_MRR_ESPE",                
        		 "BOARD_E4D_BOX",                 
        		 "BOARD_RESP32_CUSTOM",           
        		 "BOARD_FYSETC_E4",               
        		 "BOARD_PANDA_ZHU",               
        		 "BOARD_PANDA_M4",              
        		"BOARD_MKS_TINYBEE",             
        		"BOARD_ENWI_ESPNP",              

        		
        		"BOARD_AGCM4_RAMPS_144",         
        		"BOARD_BRICOLEMON_V1_0",         
        		"BOARD_BRICOLEMON_LITE_V1_0",    


        		 "BOARD_CUSTOM",                  


        		 "BOARD_LINUX_RAMPS",             

        		

        		
        		

        };

        for (String option : placasOptions) {
        	placasComboBox.addItem(option);
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
        
        
        
        
        compilarButton = new JButton("Compilar Firmware");
        compilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Criar uma nova janela
                JFrame novaJanela = new JFrame("Compilar Firmware");
                novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                novaJanela.setSize(600, 600);

                // Criar um painel para exibir o status da compilação
                JPanel painel = new JPanel(new BorderLayout());

                JTextArea statusTextArea = new JTextArea();
                statusTextArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(statusTextArea);

                painel.add(scrollPane, BorderLayout.CENTER);


      


                novaJanela.add(painel);

                // Tornar a janela visível
                novaJanela.setVisible(true);

                // Fechar a janela atual
                JFrame janelaAtual = (JFrame) SwingUtilities.getWindowAncestor(compilarButton);
                janelaAtual.dispose();

                // Compilar o Marlin usando o PlatformIO em uma thread separada
                Thread compilarThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String diretorioMarlin = System.getProperty("user.home") + "/Downloads/Marlin-2.1.2.1";
                        String comando = diretorioMarlin + "/platformio.exe run";

                        try {
                            ProcessBuilder builder = new ProcessBuilder(comando.split(" "));
                            builder.directory(new File(diretorioMarlin));
                            Process processo = builder.start();

                            // Ler a saída do processo
                            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
                            String linha;
                            while ((linha = leitor.readLine()) != null) {
                                // Exibir a linha do código de compilação
                                statusTextArea.append(linha + "\n");
                            }

                            // Aguardar o término do processo
                            int resultado = processo.waitFor();
                            if (resultado == 0) {
                                statusTextArea.append("Compilação concluída com sucesso.");
                            } else {
                                statusTextArea.append("Erro na compilação. Código de saída: " + resultado);
                            }
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                            statusTextArea.append("Erro na compilação: " + ex.getMessage());
                        }
                    }
                });

                // Iniciar a thread de compilação
                compilarThread.start();
            }
        });
        add(compilarButton);


    
        
        
        
        
        
     

      


        // Criar botão de copiar
        copiarButton = new JButton("Montar Firmware");
        copiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copiarArquivos();
               
            }
        });
        add(copiarButton);
        
        carregarFabricantes();
         carregarPastas();
         carregarMaquinas();
    }
    


	private void carregarFabricantes() {
        // Definir o diretório dos fabricantes
        String path = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "config" + File.separator + "examples";
        File fabricanteDir = new File(path);

        // Verificar se o diretório existe
        if (fabricanteDir.exists() && fabricanteDir.isDirectory()) {
            // Obter os nomes dos fabricantes
            File[] files = fabricanteDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        fabricantes.add(file.getName());
                    }
                }
            }
        }

        // Preencher a select box do fabricante
        for (String fabricante : fabricantes) {
            fabricanteComboBox.addItem(fabricante);
        }
    }

    private void carregarMaquinas() {
        // Limpar a lista de máquinas
        maquinas.clear();
        maquinaComboBox.removeAllItems();

        // Obter o fabricante selecionado
        String fabricanteSelecionado = (String) fabricanteComboBox.getSelectedItem();

        // Definir o diretório das máquinas
        File maquinasDir = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "config" + File.separator + "examples" + File.separator + fabricanteSelecionado);

        // Verificar se o diretório existe
        if (maquinasDir.exists() && maquinasDir.isDirectory()) {
            // Obter os nomes das máquinas
            File[] files = maquinasDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        maquinas.add(file.getName());
                    }
                }
            }
        }

        // Preencher a select box das máquinas
        for (String maquina : maquinas) {
            maquinaComboBox.addItem(maquina);
        }
    }

    private void carregarPastas() {
        // Limpar a lista de pastas
        pastas.clear();
        pastaComboBox.removeAllItems();

        // Obter o fabricante e a máquina selecionados
        String fabricanteSelecionado = (String) fabricanteComboBox.getSelectedItem();
        String maquinaSelecionada = (String) maquinaComboBox.getSelectedItem();

        // Definir o diretório das pastas
        File pastasDir = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "config" + File.separator + "examples" + File.separator + fabricanteSelecionado + File.separator + maquinaSelecionada);

        // Verificar se o diretório existe
        if (pastasDir.exists() && pastasDir.isDirectory()) {
            // Obter os nomes das pastas
            File[] files = pastasDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        pastas.add(file.getName());
                    }
                }
            }
        }

        // Preencher a select box das pastas
        for (String pasta : pastas) {
            pastaComboBox.addItem(pasta);
        }
    }

    private void copiarArquivos() {
        // Obter o fabricante, a máquina e a pasta selecionados
        String fabricanteSelecionado = (String) fabricanteComboBox.getSelectedItem();
        String maquinaSelecionada = (String) maquinaComboBox.getSelectedItem();
        String pastaSelecionada = (String) pastaComboBox.getSelectedItem();

      
           // Obter o chipset selecionado
            selectedChipset = (String) chipsetComboBox.getSelectedItem();
            selectedPlacas = (String)  placasComboBox.getSelectedItem();
            selectedPortaSerial = (String) portaserialComboBox.getSelectedItem();
            selectedbaudrate = (String) baudrateComboBox.getSelectedItem();

            // Definir o diretório da pasta selecionada
            File pastaDir = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "config" + File.separator + "examples" + File.separator + fabricanteSelecionado + File.separator + maquinaSelecionada + File.separator + pastaSelecionada);

            // Verificar se o diretório existe
            if (pastaDir.exists() && pastaDir.isDirectory()) {
                // Obter o diretório da área de trabalho
                String desktopPath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "Marlin";
                // Copiar os arquivos para a área de trabalho
                File[] files = pastaDir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            try {
                                Path sourcePath = file.toPath();
                                Path destinationPath = Paths.get(desktopPath, file.getName());

                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // Exibir uma mensagem de sucesso
                    JOptionPane.showMessageDialog(this, "O Firmware foi montado!.");
                }
            }
        else {
            // Copiar os arquivos da pasta do segundo select
            String maquinaSelecionada1 = (String) maquinaComboBox.getSelectedItem();

            File maquinaDir = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "config" + File.separator + "examples" + File.separator + fabricanteSelecionado + File.separator + maquinaSelecionada1);

            // Verificar se o diretório existe
            if (maquinaDir.exists() && maquinaDir.isDirectory()) {
                File[] files = maquinaDir.listFiles();
                if (files != null) {
                    // Obter o diretório da área de trabalho
                    String desktopPath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "Marlin";
                    for (File file : files) {
                        if (file.isFile()) {
                            try {
                                Path sourcePath = file.toPath();
                                Path destinationPath = Paths.get(desktopPath, file.getName());

                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // Exibir uma mensagem de sucesso
                    JOptionPane.showMessageDialog(this, "O Firmware foi montado com sucesso!!!.");
                }
            }
        }

        // Supondo que você tenha obtido o valor selecionado na caixa de seleção

        // Ler o conteúdo do arquivo platformio.ini
        Path filePath = Paths.get(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "platformio.ini");
        Path filePath1 = Paths.get(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "Marlin-2.1.2.1" + File.separator + "Marlin"+ File.separator + "Configuration.h");
         
        List<String> lines1;
    
        List<String> lines;
       
        try {
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            lines1 = Files.readAllLines(filePath1, StandardCharsets.UTF_8);
     
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        // Procurar pela linha que contém "default_envs ="
        for (int i = 0; i < lines.size(); i++){
        	 
        	if (lines1.get(i).startsWith("#define SERIAL_PORT ")) {
              
                lines1.set(i, "#define SERIAL_PORT " + selectedPortaSerial);
              
            }
        	
        	if (lines1.get(i).startsWith("#define BAUDRATE ")) {
                
                lines1.set(i, "#define BAUDRATE " + selectedbaudrate);
              
            }
        	
        	
        	if (lines1.get(i).startsWith("  #define MOTHERBOARD ")) {
                
                lines1.set(i, "  #define MOTHERBOARD " + selectedPlacas);
              
            }
        	 
        	       	
        	
            if (lines.get(i).startsWith("default_envs =")) {
                // Substituir o valor após "default_envs ="
                lines.set(i, "default_envs = " + selectedChipset);
                
            }
        }

        // Escrever as alterações de volta no arquivo platformio.ini
        try {
            Files.write(filePath, lines, StandardCharsets.UTF_8);
            Files.write(filePath1, lines1, StandardCharsets.UTF_8);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new SelectBoxExample();
               
                  
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
