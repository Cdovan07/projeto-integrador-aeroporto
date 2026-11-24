package aeroporto;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

    private SistemaAeroporto sistema;

    private JPanel painelPrincipal;
    private CardLayout layoutPrincipal;

    private Passageiro passageiroLogado;

    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoTelefone;
    private JTextField campoPassaporte;

    private JTextField campoCodigoVoo;
    private JTextField campoOrigem;
    private JTextField campoDestino;
    private JTextField campoDataHora;
    private JTextField campoStatusVoo;

    private JComboBox<String> selecaoPassageiro;
    private JComboBox<String> selecaoVoo;
    private JComboBox<String> selecaoVooPassageiro;

    private DefaultTableModel modeloTabela;
    private DefaultTableModel modeloTabelaVoos;
    private DefaultTableModel modeloTabelaReservas;
    private DefaultTableModel modeloReservasPassageiro;

    private JTable tabelaPassageiros;
    private JTable tabelaReservas;
    private JTable tabelaVoos;
    private JTable tabelaReservasPassageiro;

    private JTextArea areaNotificacoes;

    private JLabel valorPassageiros;
    private JLabel valorVoos;
    private JLabel valorReservas;

    public TelaPrincipal() {
        sistema = new SistemaAeroporto(true);

        configurarEstilo();

        setTitle("Sistema de Gerenciamento de Aeroporto");
        setSize(1000, 650);
        setMinimumSize(new java.awt.Dimension(850, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layoutPrincipal = new CardLayout();
        painelPrincipal = new JPanel(layoutPrincipal);

        painelPrincipal.add(criarTelaEscolhaPerfil(), "inicio");
        painelPrincipal.add(criarTelaLoginPassageiro(), "loginPassageiro");

        add(painelPrincipal);

        layoutPrincipal.show(painelPrincipal, "inicio");
    }

    private void configurarEstilo() {
        Color azulEscuro = new Color(20, 45, 75);
        Color azulClaro = new Color(230, 240, 250);

        UIManager.put("Panel.background", azulClaro);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.PLAIN, 14));
        UIManager.put("Button.font",
                new Font("Arial", Font.BOLD, 13));
        UIManager.put("Label.font",
                new Font("Arial", Font.PLAIN, 14));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 14));
        UIManager.put("ComboBox.font",
                new Font("Arial", Font.PLAIN, 14));
        UIManager.put("TabbedPane.selected", Color.WHITE);
        UIManager.put("TabbedPane.background", azulClaro);
        UIManager.put("TabbedPane.foreground", azulEscuro);
    }

    private void estilizarBotao(JButton botao) {
        botao.setBackground(new Color(20, 65, 110));
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 13));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    }

    private void estilizarTabela(JTable tabela) {
        tabela.setFont(new Font("Arial", Font.PLAIN, 13));
        tabela.setRowHeight(28);
        tabela.setBackground(Color.WHITE);
        tabela.setSelectionBackground(new Color(190, 215, 240));
        tabela.setSelectionForeground(Color.BLACK);
        tabela.setGridColor(new Color(220, 225, 230));

        tabela.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 13));
        tabela.getTableHeader().setBackground(
                new Color(20, 45, 75));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setReorderingAllowed(false);
    }

    private void estilizarFormulario(JPanel formulario) {
        formulario.setBackground(Color.WHITE);
        formulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 210, 225)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
    }

    private JPanel criarTelaEscolhaPerfil() {
        JPanel painel = new JPanel(new GridLayout(4, 1, 15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(100, 180, 100, 180));
        painel.setBackground(new Color(230, 240, 250));

        JLabel titulo = new JLabel(
                "Sistema de Gerenciamento de Aeroporto",
                JLabel.CENTER
        );
        titulo.setFont(new Font("Arial", Font.BOLD, 23));
        titulo.setForeground(new Color(20, 45, 75));

        JLabel descricao = new JLabel(
                "Selecione como deseja acessar o sistema",
                JLabel.CENTER
        );

        JButton botaoFuncionario = new JButton("Entrar como funcionário");
        estilizarBotao(botaoFuncionario);
        botaoFuncionario.addActionListener(e -> loginFuncionario());

        JButton botaoPassageiro = new JButton("Entrar como passageiro");
        estilizarBotao(botaoPassageiro);
        botaoPassageiro.addActionListener(e ->
                layoutPrincipal.show(painelPrincipal, "loginPassageiro"));

        painel.add(titulo);
        painel.add(descricao);
        painel.add(botaoFuncionario);
        painel.add(botaoPassageiro);

        return painel;
    }

    private void loginFuncionario() {
        JPasswordField campoSenha = new JPasswordField();

        int opcao = JOptionPane.showConfirmDialog(
                this,
                new Object[]{"Digite a senha do funcionário:", campoSenha},
                "Acesso do funcionário",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opcao != JOptionPane.OK_OPTION) {
            return;
        }

        String senha = new String(campoSenha.getPassword());

        if (!senha.equals("poo")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Senha incorreta!",
                    "Acesso negado",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Login realizado com sucesso!"
        );

        abrirAreaFuncionario();
    }

    private JPanel criarTelaLoginPassageiro() {
        JPanel painel = new JPanel(new BorderLayout(15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(100, 250, 100, 250));

        JLabel titulo = new JLabel("Área do Passageiro", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(20, 45, 75));

        JPanel formulario = new JPanel(new GridLayout(0, 1, 8, 8));

        JTextField campoCpfLogin = new JTextField();
        JPasswordField campoSenhaLogin = new JPasswordField();

        formulario.add(new JLabel("CPF:"));
        formulario.add(campoCpfLogin);

        formulario.add(new JLabel("Senha:"));
        formulario.add(campoSenhaLogin);

        JButton botaoEntrar = new JButton("Entrar");
        estilizarBotao(botaoEntrar);

        botaoEntrar.addActionListener(e -> {
            String cpf = campoCpfLogin.getText().trim();
            String senha = new String(campoSenhaLogin.getPassword());

            if (cpf.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o CPF e a senha."
                );
                return;
            }

            Passageiro passageiro = sistema.autenticarPassageiro(cpf, senha);

            if (passageiro == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "CPF ou senha incorretos.",
                        "Falha no login",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            passageiroLogado = passageiro;
            abrirAreaPassageiro();
        });

        JButton botaoCadastrar = new JButton("Criar cadastro");
        estilizarBotao(botaoCadastrar);
        botaoCadastrar.addActionListener(e -> cadastrarNovoPassageiro());

        JButton botaoVoltar = new JButton("Voltar");
        estilizarBotao(botaoVoltar);
        botaoVoltar.addActionListener(e ->
                layoutPrincipal.show(painelPrincipal, "inicio"));

        JPanel botoes = new JPanel(new GridLayout(3, 1, 8, 8));
        botoes.setBackground(new Color(230, 240, 250));
        botoes.add(botaoEntrar);
        botoes.add(botaoCadastrar);
        botoes.add(botaoVoltar);

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(formulario, BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        return painel;
    }

    private void cadastrarNovoPassageiro() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField email = new JTextField();
        JTextField telefone = new JTextField();
        JTextField passaporte = new JTextField();
        JPasswordField senha = new JPasswordField();
        JPasswordField confirmarSenha = new JPasswordField();

        JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));

        formulario.add(new JLabel("Nome:"));
        formulario.add(nome);

        formulario.add(new JLabel("CPF:"));
        formulario.add(cpf);

        formulario.add(new JLabel("E-mail:"));
        formulario.add(email);

        formulario.add(new JLabel("Telefone:"));
        formulario.add(telefone);

        formulario.add(new JLabel("Número do passaporte:"));
        formulario.add(passaporte);

        formulario.add(new JLabel("Senha:"));
        formulario.add(senha);

        formulario.add(new JLabel("Confirmar senha:"));
        formulario.add(confirmarSenha);

        int opcao = JOptionPane.showConfirmDialog(
                this,
                formulario,
                "Cadastro de passageiro",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcao != JOptionPane.OK_OPTION) {
            return;
        }

        String nomeTexto = nome.getText().trim();
        String cpfTexto = cpf.getText().trim();
        String emailTexto = email.getText().trim();
        String telefoneTexto = telefone.getText().trim();
        String passaporteTexto = passaporte.getText().trim();
        String senhaTexto = new String(senha.getPassword());
        String confirmacao = new String(confirmarSenha.getPassword());

        if (nomeTexto.isEmpty() || cpfTexto.isEmpty()
                || emailTexto.isEmpty() || telefoneTexto.isEmpty()
                || passaporteTexto.isEmpty() || senhaTexto.isEmpty()
                || confirmacao.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Preencha todos os campos."
            );
            return;
        }

        if (!senhaTexto.equals(confirmacao)) {
            JOptionPane.showMessageDialog(
                    this,
                    "As senhas não coincidem."
            );
            return;
        }

        if (senhaTexto.length() < 4) {
            JOptionPane.showMessageDialog(
                    this,
                    "A senha deve ter pelo menos 4 caracteres."
            );
            return;
        }

        try {
            Passageiro passageiro = new Passageiro(
                    nomeTexto,
                    cpfTexto,
                    emailTexto,
                    telefoneTexto,
                    passaporteTexto,
                    senhaTexto
            );

            sistema.cadastrarPassageiro(passageiro);

            JOptionPane.showMessageDialog(
                    this,
                    "Cadastro realizado com sucesso! Agora você pode entrar com seu CPF e senha."
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao cadastrar",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void abrirAreaFuncionario() {
        JTabbedPane abas = new JTabbedPane();

        abas.addTab("Início", criarTelaInicio());
        abas.addTab("Passageiros", criarTelaPassageiros());
        abas.addTab("Voos", criarTelaVoos());
        abas.addTab("Reservas", criarTelaReservas());
        abas.addTab("Notificações", criarTelaNotificacoes());

        abas.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel painel = new JPanel(new BorderLayout());
        painel.add(criarCabecalhoUsuario("Funcionário"), BorderLayout.NORTH);
        painel.add(abas, BorderLayout.CENTER);

        painelPrincipal.add(painel, "funcionario");
        carregarDadosNaTela();

        layoutPrincipal.show(painelPrincipal, "funcionario");
    }

    private void abrirAreaPassageiro() {
        JTabbedPane abas = new JTabbedPane();

        abas.addTab("Voos disponíveis", criarTelaVoosPassageiro());
        abas.addTab("Minhas reservas", criarTelaReservasPassageiro());

        abas.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel painel = new JPanel(new BorderLayout());
        painel.add(
                criarCabecalhoUsuario("Passageiro: " + passageiroLogado.getNome()),
                BorderLayout.NORTH
        );
        painel.add(abas, BorderLayout.CENTER);

        painelPrincipal.add(painel, "passageiro");

        atualizarTabelaVoosPassageiro();
        atualizarTabelaReservasPassageiro();

        layoutPrincipal.show(painelPrincipal, "passageiro");
    }

    private JPanel criarCabecalhoUsuario(String texto) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(new Color(20, 45, 75));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel usuario = new JLabel(texto);
        usuario.setForeground(Color.WHITE);
        usuario.setFont(new Font("Arial", Font.BOLD, 15));

        JButton botaoSair = new JButton("Sair da conta");
        estilizarBotao(botaoSair);

        botaoSair.addActionListener(e -> {
            passageiroLogado = null;
            layoutPrincipal.show(painelPrincipal, "inicio");
        });

        painel.add(usuario, BorderLayout.WEST);
        painel.add(botaoSair, BorderLayout.EAST);

        return painel;
    }

    private JPanel criarTelaVoosPassageiro() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Voos cadastrados no sistema");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        modeloTabelaVoos = new DefaultTableModel(
                new Object[]{"Código", "Origem", "Destino", "Data e hora", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabelaVoos = new JTable(modeloTabelaVoos);
        estilizarTabela(tabelaVoos);

        JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));
        formulario.add(new JLabel("Selecione o voo:"));

        selecaoVooPassageiro = new JComboBox<>();
        formulario.add(selecaoVooPassageiro);

        JButton botaoReservar = new JButton("Reservar voo");
        estilizarBotao(botaoReservar);
        botaoReservar.addActionListener(e -> cadastrarReservaPassageiro());

        formulario.add(botaoReservar);

        estilizarFormulario(formulario);

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaVoos), BorderLayout.CENTER);
        painel.add(formulario, BorderLayout.SOUTH);

        atualizarTabelaVoosPassageiro();

        return painel;
    }

    private void atualizarTabelaVoosPassageiro() {
        if (modeloTabelaVoos == null) {
            return;
        }

        modeloTabelaVoos.setRowCount(0);

        for (Voo voo : sistema.listarVoos()) {
            modeloTabelaVoos.addRow(new Object[]{
                    voo.getCodigo(),
                    voo.getOrigem(),
                    voo.getDestino(),
                    voo.getDataHora(),
                    voo.getStatus()
            });
        }

        if (selecaoVooPassageiro != null) {
            selecaoVooPassageiro.removeAllItems();

            for (Voo voo : sistema.listarVoos()) {
                selecaoVooPassageiro.addItem(
                        voo.getCodigo() + " - " + voo.getOrigem()
                        + " para " + voo.getDestino()
                        + " (" + voo.getStatus() + ")"
                );
            }
        }
    }

    private void cadastrarReservaPassageiro() {
        try {
            int indiceVoo = selecaoVooPassageiro.getSelectedIndex();

            if (indiceVoo == -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Não existem voos cadastrados para reservar."
                );
                return;
            }

            List<Voo> voos = sistema.listarVoos();
            Voo voo = voos.get(indiceVoo);

            if (voo.getStatus().equalsIgnoreCase("Cancelado")
                    || voo.getStatus().equalsIgnoreCase("Concluído")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Não é possível reservar esse voo."
                );
                return;
            }

            String codigo = JOptionPane.showInputDialog(
                    this,
                    "Digite um código para sua reserva:"
            );

            if (codigo == null) {
                return;
            }

            codigo = codigo.trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "O código da reserva é obrigatório."
                );
                return;
            }

            Reserva reserva = new Reserva(
                    codigo,
                    LocalDateTime.now(),
                    "Pendente",
                    passageiroLogado,
                    voo
            );

            sistema.cadastrarReserva(reserva);

            atualizarTabelaReservasPassageiro();

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva realizada com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao reservar voo",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private JPanel criarTelaReservasPassageiro() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Minhas reservas");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        modeloReservasPassageiro = new DefaultTableModel(
                new Object[]{
                    "Código",
                    "Voo",
                    "Origem",
                    "Destino",
                    "Data da reserva",
                    "Status"
                }, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabelaReservasPassageiro = new JTable(modeloReservasPassageiro);
        estilizarTabela(tabelaReservasPassageiro);

        JButton botaoCancelar = new JButton("Cancelar minha reserva");
        estilizarBotao(botaoCancelar);
        botaoCancelar.addActionListener(e -> cancelarReservaPassageiro());

        JPanel botoes = new JPanel();
        botoes.setBackground(new Color(230, 240, 250));
        botoes.add(botaoCancelar);

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaReservasPassageiro), BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        atualizarTabelaReservasPassageiro();

        return painel;
    }

    private void atualizarTabelaReservasPassageiro() {
        if (modeloReservasPassageiro == null || passageiroLogado == null) {
            return;
        }

        modeloReservasPassageiro.setRowCount(0);

        for (Reserva reserva : sistema.listarReservas()) {
            if (reserva.getPassageiro().getCpf()
                    .equals(passageiroLogado.getCpf())) {

                modeloReservasPassageiro.addRow(new Object[]{
                        reserva.getCodigo(),
                        reserva.getVoo().getCodigo(),
                        reserva.getVoo().getOrigem(),
                        reserva.getVoo().getDestino(),
                        reserva.getDataReserva(),
                        reserva.getStatus()
                });
            }
        }
    }

    private void cancelarReservaPassageiro() {
        int linha = tabelaReservasPassageiro.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione uma reserva na tabela."
            );
            return;
        }

        String codigo = modeloReservasPassageiro
                .getValueAt(linha, 0).toString();

        Reserva reserva = sistema.consultarReserva(codigo);

        if (reserva == null
                || !reserva.getPassageiro().getCpf()
                        .equals(passageiroLogado.getCpf())) {
            JOptionPane.showMessageDialog(
                    this,
                    "Você não tem permissão para cancelar essa reserva.",
                    "Acesso negado",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Deseja cancelar a reserva " + codigo + "?",
                "Confirmar cancelamento",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            sistema.cancelarReserva(codigo);
            atualizarTabelaReservasPassageiro();

            JOptionPane.showMessageDialog(
                    this,
                    "Sua reserva foi cancelada com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao cancelar reserva",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private JPanel criarTelaInicio() {
        JPanel painel = new JPanel(new BorderLayout(20, 20));
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("Painel do Aeroporto");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setForeground(new Color(20, 45, 75));

        JLabel descricao = new JLabel(
                "Bem-vindo ao Sistema de Gerenciamento de Aeroporto"
        );
        descricao.setFont(new Font("Arial", Font.PLAIN, 15));

        JPanel cabecalho = new JPanel(new GridLayout(2, 1, 5, 5));
        cabecalho.setBackground(new Color(230, 240, 250));
        cabecalho.add(titulo);
        cabecalho.add(descricao);

        JPanel painelResumo = new JPanel(new GridLayout(1, 3, 20, 20));
        painelResumo.setBackground(new Color(230, 240, 250));

        valorPassageiros = criarCartao(
                painelResumo, "Passageiros cadastrados"
        );

        valorVoos = criarCartao(
                painelResumo, "Voos cadastrados"
        );

        valorReservas = criarCartao(
                painelResumo, "Reservas cadastradas"
        );

        painel.add(cabecalho, BorderLayout.NORTH);
        painel.add(painelResumo, BorderLayout.CENTER);

        atualizarPainelInicio();

        return painel;
    }

    private JLabel criarCartao(JPanel painel, String titulo) {
        JPanel cartao = new JPanel(new GridLayout(2, 1, 5, 5));

        cartao.setBackground(Color.WHITE);
        cartao.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 210, 225)
                ),
                BorderFactory.createEmptyBorder(20, 10, 20, 10)
        ));

        JLabel nome = new JLabel(titulo, JLabel.CENTER);
        nome.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel valor = new JLabel("0", JLabel.CENTER);
        valor.setFont(new Font("Arial", Font.BOLD, 32));
        valor.setForeground(new Color(20, 65, 110));

        cartao.add(nome);
        cartao.add(valor);

        painel.add(cartao);

        return valor;
    }

    private void atualizarPainelInicio() {
        if (valorPassageiros != null) {
            valorPassageiros.setText(
                    String.valueOf(sistema.listarPassageiros().size())
            );
        }

        if (valorVoos != null) {
            valorVoos.setText(
                    String.valueOf(sistema.listarVoos().size())
            );
        }

        if (valorReservas != null) {
            valorReservas.setText(
                    String.valueOf(sistema.listarReservas().size())
            );
        }
    }

    private JPanel criarTelaPassageiros() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));

        campoNome = new JTextField();
        campoCpf = new JTextField();
        campoEmail = new JTextField();
        campoTelefone = new JTextField();
        campoPassaporte = new JTextField();

        formulario.add(new JLabel("Nome:"));
        formulario.add(campoNome);

        formulario.add(new JLabel("CPF:"));
        formulario.add(campoCpf);

        formulario.add(new JLabel("E-mail:"));
        formulario.add(campoEmail);

        formulario.add(new JLabel("Telefone:"));
        formulario.add(campoTelefone);

        formulario.add(new JLabel("Número do passaporte:"));
        formulario.add(campoPassaporte);

        JButton botaoCadastrar = new JButton("Cadastrar passageiro");
        estilizarBotao(botaoCadastrar);
        botaoCadastrar.addActionListener(e -> cadastrarPassageiro());

        formulario.add(botaoCadastrar);

        JButton botaoExcluir = new JButton("Excluir passageiro selecionado");
        estilizarBotao(botaoExcluir);
        botaoExcluir.addActionListener(e -> excluirPassageiro());

        formulario.add(botaoExcluir);

        estilizarFormulario(formulario);

        modeloTabela = new DefaultTableModel(
                new Object[]{"Nome", "CPF", "E-mail", "Telefone", "Passaporte"}, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabelaPassageiros = new JTable(modeloTabela);
        estilizarTabela(tabelaPassageiros);

        painel.add(formulario, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaPassageiros), BorderLayout.CENTER);

        return painel;
    }

    private void cadastrarPassageiro() {
        try {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String email = campoEmail.getText().trim();
            String telefone = campoTelefone.getText().trim();
            String passaporte = campoPassaporte.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty()
                    || telefone.isEmpty() || passaporte.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            Passageiro passageiro = new Passageiro(
                    nome, cpf, email, telefone, passaporte
            );

            sistema.cadastrarPassageiro(passageiro);

            atualizarTabelaPassageiros();
            atualizarSelecoesReserva();
            atualizarPainelInicio();

            JOptionPane.showMessageDialog(
                    this,
                    "Passageiro cadastrado com sucesso!"
            );

            campoNome.setText("");
            campoCpf.setText("");
            campoEmail.setText("");
            campoTelefone.setText("");
            campoPassaporte.setText("");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao cadastrar",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void excluirPassageiro() {
        int linha = tabelaPassageiros.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um passageiro na tabela."
            );
            return;
        }

        String cpf = modeloTabela.getValueAt(linha, 1).toString();
        String nome = modeloTabela.getValueAt(linha, 0).toString();

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir o passageiro " + nome + "?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            sistema.excluirPassageiro(cpf);

            atualizarTabelaPassageiros();
            atualizarSelecoesReserva();
            atualizarPainelInicio();

            JOptionPane.showMessageDialog(
                    this,
                    "Passageiro excluído com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao excluir passageiro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void atualizarTabelaPassageiros() {
        modeloTabela.setRowCount(0);

        for (Passageiro passageiro : sistema.listarPassageiros()) {
            modeloTabela.addRow(new Object[]{
                    passageiro.getNome(),
                    passageiro.getCpf(),
                    passageiro.getEmail(),
                    passageiro.getTelefone(),
                    passageiro.getNumeroPassaporte()
            });
        }
    }

    private JPanel criarTelaVoos() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));

        campoCodigoVoo = new JTextField();
        campoOrigem = new JTextField();
        campoDestino = new JTextField();
        campoDataHora = new JTextField();
        campoStatusVoo = new JTextField("Programado");

        formulario.add(new JLabel("Código do voo:"));
        formulario.add(campoCodigoVoo);

        formulario.add(new JLabel("Origem:"));
        formulario.add(campoOrigem);

        formulario.add(new JLabel("Destino:"));
        formulario.add(campoDestino);

        formulario.add(new JLabel("Data e hora (AAAA-MM-DDTHH:MM):"));
        formulario.add(campoDataHora);

        formulario.add(new JLabel("Status:"));
        formulario.add(campoStatusVoo);

        JButton botaoCadastrar = new JButton("Cadastrar voo");
        estilizarBotao(botaoCadastrar);
        botaoCadastrar.addActionListener(e -> cadastrarVoo());

        formulario.add(botaoCadastrar);

        JButton botaoAlterarStatus = new JButton("Alterar status do voo");
        estilizarBotao(botaoAlterarStatus);
        botaoAlterarStatus.addActionListener(e -> alterarStatusVoo());

        formulario.add(botaoAlterarStatus);

        JButton botaoExcluir = new JButton("Excluir voo selecionado");
        estilizarBotao(botaoExcluir);
        botaoExcluir.addActionListener(e -> excluirVoo());

        formulario.add(botaoExcluir);

        estilizarFormulario(formulario);

        modeloTabelaVoos = new DefaultTableModel(
                new Object[]{"Código", "Origem", "Destino", "Data e hora", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabelaVoos = new JTable(modeloTabelaVoos);
        estilizarTabela(tabelaVoos);

        painel.add(formulario, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaVoos), BorderLayout.CENTER);

        return painel;
    }

    private void cadastrarVoo() {
        try {
            String codigo = campoCodigoVoo.getText().trim();
            String origem = campoOrigem.getText().trim();
            String destino = campoDestino.getText().trim();
            String dataHoraTexto = campoDataHora.getText().trim();
            String status = campoStatusVoo.getText().trim();

            if (codigo.isEmpty() || origem.isEmpty() || destino.isEmpty()
                    || dataHoraTexto.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            LocalDateTime dataHora = LocalDateTime.parse(dataHoraTexto);

            Voo voo = new Voo(
                    codigo, origem, destino, dataHora, status
            );

            sistema.cadastrarVoo(voo);

            NotificadorTela notificador = new NotificadorTela(areaNotificacoes);
            voo.adicionarObservador(notificador);

            atualizarTabelaVoos();
            atualizarSelecoesReserva();
            atualizarPainelInicio();

            JOptionPane.showMessageDialog(
                    this,
                    "Voo cadastrado com sucesso!"
            );

            campoCodigoVoo.setText("");
            campoOrigem.setText("");
            campoDestino.setText("");
            campoDataHora.setText("");
            campoStatusVoo.setText("Programado");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao cadastrar voo",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void excluirVoo() {
        int linha = tabelaVoos.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um voo na tabela."
            );
            return;
        }

        String codigo = modeloTabelaVoos.getValueAt(linha, 0).toString();

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir o voo " + codigo + "?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            sistema.excluirVoo(codigo);

            atualizarTabelaVoos();
            atualizarSelecoesReserva();
            atualizarPainelInicio();

            JOptionPane.showMessageDialog(
                    this,
                    "Voo excluído com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao excluir voo",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void alterarStatusVoo() {
        try {
            int linha = tabelaVoos.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Selecione um voo na tabela."
                );
                return;
            }

            String codigo = modeloTabelaVoos.getValueAt(linha, 0).toString();

            Voo vooSelecionado = null;

            for (Voo voo : sistema.listarVoos()) {
                if (voo.getCodigo().equals(codigo)) {
                    vooSelecionado = voo;
                    break;
                }
            }

            if (vooSelecionado == null) {
                return;
            }

            String[] statusDisponiveis = {
                    "Programado",
                    "Embarque",
                    "Atrasado",
                    "Cancelado",
                    "Concluído"
            };

            String novoStatus = (String) JOptionPane.showInputDialog(
                    this,
                    "Selecione o novo status do voo:",
                    "Alterar status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    statusDisponiveis,
                    vooSelecionado.getStatus()
            );

            if (novoStatus == null) {
                return;
            }

            sistema.alterarStatusVoo(codigo, novoStatus);

            atualizarTabelaVoos();

            JOptionPane.showMessageDialog(
                    this,
                    "Status do voo atualizado com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao alterar status",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void atualizarTabelaVoos() {
        modeloTabelaVoos.setRowCount(0);

        for (Voo voo : sistema.listarVoos()) {
            modeloTabelaVoos.addRow(new Object[]{
                    voo.getCodigo(),
                    voo.getOrigem(),
                    voo.getDestino(),
                    voo.getDataHora(),
                    voo.getStatus()
            });
        }
    }

    private JPanel criarTelaReservas() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));

        selecaoPassageiro = new JComboBox<>();
        selecaoVoo = new JComboBox<>();

        formulario.add(new JLabel("Passageiro:"));
        formulario.add(selecaoPassageiro);

        formulario.add(new JLabel("Voo:"));
        formulario.add(selecaoVoo);

        JButton botaoCadastrar = new JButton("Cadastrar reserva");
        estilizarBotao(botaoCadastrar);
        botaoCadastrar.addActionListener(e -> cadastrarReserva());

        formulario.add(botaoCadastrar);

        estilizarFormulario(formulario);

        modeloTabelaReservas = new DefaultTableModel(
                new Object[]{
                    "Código",
                    "Passageiro",
                    "Voo",
                    "Origem",
                    "Destino",
                    "Data da reserva",
                    "Status"
                }, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabelaReservas = new JTable(modeloTabelaReservas);
        estilizarTabela(tabelaReservas);

        JButton botaoConfirmar = new JButton("Confirmar reserva");
        estilizarBotao(botaoConfirmar);
        botaoConfirmar.addActionListener(e -> confirmarReserva());

        JButton botaoCancelar = new JButton("Cancelar reserva");
        estilizarBotao(botaoCancelar);
        botaoCancelar.addActionListener(e -> cancelarReserva());

        JButton botaoExcluir = new JButton("Excluir reserva");
        estilizarBotao(botaoExcluir);
        botaoExcluir.addActionListener(e -> excluirReserva());

        JPanel botoes = new JPanel();
        botoes.setBackground(new Color(230, 240, 250));

        botoes.add(botaoConfirmar);
        botoes.add(botaoCancelar);
        botoes.add(botaoExcluir);

        painel.add(formulario, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaReservas), BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        atualizarSelecoesReserva();

        return painel;
    }

    private void atualizarSelecoesReserva() {
        if (selecaoPassageiro == null || selecaoVoo == null) {
            return;
        }

        selecaoPassageiro.removeAllItems();

        for (Passageiro passageiro : sistema.listarPassageiros()) {
            selecaoPassageiro.addItem(
                    passageiro.getNome() + " - CPF: " + passageiro.getCpf()
            );
        }

        selecaoVoo.removeAllItems();

        for (Voo voo : sistema.listarVoos()) {
            selecaoVoo.addItem(
                    voo.getCodigo() + " - " + voo.getOrigem()
                    + " para " + voo.getDestino()
            );
        }
    }

    private void cadastrarReserva() {
        try {
            int indicePassageiro = selecaoPassageiro.getSelectedIndex();
            int indiceVoo = selecaoVoo.getSelectedIndex();

            if (indicePassageiro == -1 || indiceVoo == -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Cadastre pelo menos um passageiro e um voo antes de criar uma reserva."
                );
                return;
            }

            List<Passageiro> passageiros = sistema.listarPassageiros();
            List<Voo> voos = sistema.listarVoos();

            Passageiro passageiro = passageiros.get(indicePassageiro);
            Voo voo = voos.get(indiceVoo);

            String codigo = JOptionPane.showInputDialog(
                    this,
                    "Digite o código da reserva:"
            );

            if (codigo == null) {
                return;
            }

            codigo = codigo.trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "O código da reserva é obrigatório."
                );
                return;
            }

            Reserva reserva = new Reserva(
                    codigo,
                    LocalDateTime.now(),
                    "Pendente",
                    passageiro,
                    voo
            );

            sistema.cadastrarReserva(reserva);

            atualizarTabelaReservas();
            atualizarPainelInicio();

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva cadastrada com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao cadastrar reserva",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void confirmarReserva() {
        try {
            Reserva reserva = obterReservaSelecionada();

            if (reserva == null) {
                return;
            }

            sistema.confirmarReserva(reserva.getCodigo());

            atualizarTabelaReservas();

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva confirmada com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao confirmar reserva",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void cancelarReserva() {
        try {
            Reserva reserva = obterReservaSelecionada();

            if (reserva == null) {
                return;
            }

            sistema.cancelarReserva(reserva.getCodigo());

            atualizarTabelaReservas();

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva cancelada com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao cancelar reserva",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void excluirReserva() {
        try {
            Reserva reserva = obterReservaSelecionada();

            if (reserva == null) {
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente excluir a reserva "
                    + reserva.getCodigo() + "?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirmacao != JOptionPane.YES_OPTION) {
                return;
            }

            sistema.excluirReserva(reserva.getCodigo());

            atualizarTabelaReservas();
            atualizarPainelInicio();

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva excluída com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    erro.getMessage(),
                    "Erro ao excluir reserva",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private Reserva obterReservaSelecionada() {
        int linha = tabelaReservas.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione uma reserva na tabela."
            );
            return null;
        }

        String codigo = modeloTabelaReservas.getValueAt(linha, 0).toString();

        return sistema.consultarReserva(codigo);
    }

    private void atualizarTabelaReservas() {
        modeloTabelaReservas.setRowCount(0);

        for (Reserva reserva : sistema.listarReservas()) {
            modeloTabelaReservas.addRow(new Object[]{
                    reserva.getCodigo(),
                    reserva.getPassageiro().getNome(),
                    reserva.getVoo().getCodigo(),
                    reserva.getVoo().getOrigem(),
                    reserva.getVoo().getDestino(),
                    reserva.getDataReserva(),
                    reserva.getStatus()
            });
        }
    }

    private JPanel criarTelaNotificacoes() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        areaNotificacoes = new JTextArea();
        areaNotificacoes.setEditable(false);
        areaNotificacoes.setLineWrap(true);
        areaNotificacoes.setWrapStyleWord(true);
        areaNotificacoes.setFont(new Font("Arial", Font.PLAIN, 14));
        areaNotificacoes.setBackground(Color.WHITE);
        areaNotificacoes.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel(
                "Notificações de alterações nos voos");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(new JScrollPane(areaNotificacoes), BorderLayout.CENTER);

        return painel;
    }

    private void carregarDadosNaTela() {
        atualizarTabelaPassageiros();
        atualizarTabelaVoos();
        atualizarTabelaReservas();
        atualizarSelecoesReserva();
        atualizarPainelInicio();

        for (Voo voo : sistema.listarVoos()) {
            NotificadorTela notificador =
                    new NotificadorTela(areaNotificacoes);

            voo.adicionarObservador(notificador);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(
                        null,
                        erro.getMessage(),
                        "Erro ao iniciar o sistema",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}
