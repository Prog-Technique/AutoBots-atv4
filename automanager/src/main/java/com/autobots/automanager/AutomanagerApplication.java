package com.autobots.automanager;

import java.util.Calendar;
import java.util.Date;

import com.autobots.automanager.entidades.*;
import com.autobots.automanager.enumeracoes.PerfilUsuario;
import com.autobots.automanager.enumeracoes.TipoDocumento;
import com.autobots.automanager.enumeracoes.TipoVeiculo;

import com.autobots.automanager.repositorios.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class AutomanagerApplication{



	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}


	@Component
	public static class Runner implements ApplicationRunner {

		@Autowired
		private EmpresaRepositorio repositorioEmpresa;

		@Autowired
		public ClienteRepositorio repositorio;

		@Override
		public void run(ApplicationArguments args) throws Exception {

			Calendar calendario = Calendar.getInstance();
			calendario.set(2002, 05, 15);

			Cliente cliente = new Cliente();
			cliente.setNome("Pedro Alcântara de Bragança e Bourbon");
			cliente.setDataCadastro(Calendar.getInstance().getTime());
			cliente.setDataNascimento(calendario.getTime());
			cliente.setNomeSocial("Dom Pedro");

			Telefone telefone = new Telefone();
			telefone.setDdd("21");
			telefone.setNumero("981234576");
			cliente.getTelefones().add(telefone);

			Endereco endereco = new Endereco();
			endereco.setEstado("Rio de Janeiro");
			endereco.setCidade("Rio de Janeiro");
			endereco.setBairro("Copacabana");
			endereco.setRua("Avenida Atlântica");
			endereco.setNumero("1702");
			endereco.setCodigoPostal("22021001");
			endereco.setInformacoesAdicionais("Hotel Copacabana palace");
			cliente.setEndereco(endereco);

			Documento rg = new Documento();
			rg.setTipo(TipoDocumento.RG);
			rg.setNumero("1500");

			Documento cpf = new Documento();
			cpf.setTipo(TipoDocumento.CPF);
			cpf.setNumero("00000000001");

			cliente.getDocumentos().add(rg);
			cliente.getDocumentos().add(cpf);

			repositorio.save(cliente);

			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("McQueen Automotiva");
			empresa.setNomeFantasia("Relampago Marquinhos");
			empresa.setCadastro(new Date());

			Endereco enderecoEmpresa = new Endereco();
			enderecoEmpresa.setEstado("São Paulo");
			enderecoEmpresa.setCidade("São Jasé dos Campos");
			enderecoEmpresa.setBairro("Jardim Satélite");
			enderecoEmpresa.setRua("Av. Andrômeda");
			enderecoEmpresa.setNumero("333");
			enderecoEmpresa.setCodigoPostal("12260-000");

			empresa.setEndereco(enderecoEmpresa);

			Telefone telefoneEmpresa = new Telefone();
			telefoneEmpresa.setDdd("012");
			telefoneEmpresa.setNumero("39315342");

			empresa.getTelefones().add(telefoneEmpresa);
			
			
			

			Usuario funcionario = new Usuario();
			funcionario.setNome("Marcos Paulo Braga Poca");
			funcionario.setNomeSocial("Marco");
			funcionario.getPerfis().add(PerfilUsuario.ROLE_GERENTE);

			Email emailFuncionario = new Email();
			emailFuncionario.setEndereco("marcos.co@gmail.com");

			funcionario.getEmails().add(emailFuncionario);

			Endereco enderecoFuncionario = new Endereco();
			enderecoFuncionario.setEstado("São Paulo");
			enderecoFuncionario.setCidade("São José dos Campos");
			enderecoFuncionario.setBairro("Jardim America");
			enderecoFuncionario.setRua(" R. Andorra");
			enderecoFuncionario.setNumero("500");
			enderecoFuncionario.setCodigoPostal("12235-050");

			funcionario.setEndereco(enderecoFuncionario);

			empresa.getUsuarios().add(funcionario);

			Telefone telefoneFuncionario = new Telefone();
			telefoneFuncionario.setDdd("012");
			telefoneFuncionario.setNumero("3570-5000");

			funcionario.getTelefones().add(telefoneFuncionario);

			Documento cpf2 = new Documento();
			cpf2.setDataEmissao(new Date());
			cpf2.setNumero("46861578815");
			cpf2.setTipo(TipoDocumento.CPF);

			funcionario.getDocumentos().add(cpf2);

			CredencialUsuarioSenha credencialFuncionario = new CredencialUsuarioSenha();
			credencialFuncionario.setInativo(false);
			credencialFuncionario.setNomeUsuario("marcaofuncionario");
			credencialFuncionario.setSenha("12345678");
			credencialFuncionario.setCriacao(new Date());
			credencialFuncionario.setUltimoAcesso(new Date());

			funcionario.getCredenciais().add(credencialFuncionario);

			Usuario fornecedor = new Usuario();
			fornecedor.setNome("LTDA Rei do Óleo");
			fornecedor.setNomeSocial("Rei do Óleo");
			fornecedor.getPerfis().add(PerfilUsuario.ROLE_CLIENTE);

			Email emailFornecedor = new Email();
			emailFornecedor.setEndereco("oleorei@gmail.com");

			fornecedor.getEmails().add(emailFornecedor);

			CredencialUsuarioSenha credencialFornecedor = new CredencialUsuarioSenha();
			credencialFornecedor.setInativo(false);
			credencialFornecedor.setNomeUsuario("reidooleo");
			credencialFornecedor.setSenha("12345678");
			credencialFornecedor.setCriacao(new Date());
			credencialFornecedor.setUltimoAcesso(new Date());

			fornecedor.getCredenciais().add(credencialFornecedor);

			Documento cnpj = new Documento();
			cnpj.setDataEmissao(new Date());
			cnpj.setNumero("23.440.640/0001-18");
			cnpj.setTipo(TipoDocumento.CNPJ);

			fornecedor.getDocumentos().add(cnpj);

			Endereco enderecoFornecedor = new Endereco();
			enderecoFornecedor.setEstado("São Paulo");
			enderecoFornecedor.setCidade("São José dos Campos");
			enderecoFornecedor.setBairro("Jardim Satélite");
			enderecoFornecedor.setRua("Av. Cidade Jardim");
			enderecoFornecedor.setNumero("151");
			enderecoFornecedor.setCodigoPostal("12231-675");

			fornecedor.setEndereco(enderecoFornecedor);

			empresa.getUsuarios().add(fornecedor);

			Mercadoria lanterna = new Mercadoria();
			lanterna.setCadastro(new Date());
			lanterna.setFabricao(new Date());
			lanterna.setNome("Lanterna 571-93 | Renault");
			lanterna.setValidade(new Date());
			lanterna.setQuantidade(50);
			lanterna.setValor(132.0);
			lanterna.setDescricao("Lanterna da Renault para Duster 2016/2017");

			empresa.getMercadorias().add(lanterna);

			fornecedor.getMercadorias().add(lanterna);
			
			
			

			Usuario cliente2 = new Usuario();
			cliente2.setNome("Amanda Caires Pereira");
			cliente2.setNomeSocial("Amandika");
			cliente2.getPerfis().add(PerfilUsuario.ROLE_CLIENTE);

			Email emailCliente = new Email();
			emailCliente.setEndereco("amandinha@gmail.com");

			cliente2.getEmails().add(emailCliente);

			Documento cpfCliente = new Documento();
			cpfCliente.setDataEmissao(new Date());
			cpfCliente.setNumero("84042178073");
			cpfCliente.setTipo(TipoDocumento.CPF);

			cliente2.getDocumentos().add(cpfCliente);

			CredencialUsuarioSenha credencialCliente = new CredencialUsuarioSenha();
			credencialCliente.setInativo(false);
			credencialCliente.setNomeUsuario("amandacliente");
			credencialCliente.setSenha("12345678");
			credencialCliente.setCriacao(new Date());
			credencialCliente.setUltimoAcesso(new Date());

			cliente2.getCredenciais().add(credencialCliente);

			Endereco enderecoCliente = new Endereco();
			enderecoCliente.setEstado("São Paulo");
			enderecoCliente.setCidade("São José dos Campos");
			enderecoCliente.setBairro("Distrito - Eugênio de Melo");
			enderecoCliente.setRua("Avenida Cesare Monsueto Giulio Lattes");
			enderecoCliente.setNumero("1350");
			enderecoCliente.setCodigoPostal("12247-014");

			cliente2.setEndereco(enderecoCliente);

			Veiculo veiculo = new Veiculo();
			veiculo.setPlaca("ABC-1234");
			veiculo.setModelo("HB20");
			veiculo.setTipo(TipoVeiculo.HATCH);
			veiculo.setProprietario(cliente2);

			cliente2.getVeiculos().add(veiculo);

			empresa.getUsuarios().add(cliente2);

			Servico alinhamento = new Servico();
			alinhamento.setNome("Alinhamento básico");
			alinhamento.setDescricao("Alinhamento de rodas de veículo - pequeno porte");
			alinhamento.setValor(150);

			Servico trocaParafusos = new Servico();
			trocaParafusos.setNome("Adição do parafuso com segredo");
			trocaParafusos.setDescricao("Troca de 1 parafuso normal de cada roda");
			trocaParafusos.setValor(30);

			empresa.getServicos().add(alinhamento);
			empresa.getServicos().add(trocaParafusos);

			Venda venda = new Venda();
			venda.setCadastro(new Date());
			venda.setCliente(cliente2);
			venda.getMercadorias().add(lanterna);
			venda.setIdentificacao("123456789");
			venda.setFuncionario(funcionario);
			venda.getServicos().add(trocaParafusos);
			venda.getServicos().add(alinhamento);
			venda.setVeiculo(veiculo);
			veiculo.getVendas().add(venda);

			empresa.getVendas().add(venda);

			repositorioEmpresa.save(empresa);

			Mercadoria rodaLigaLeve2 = new Mercadoria();
			rodaLigaLeve2.setCadastro(new Date());
			rodaLigaLeve2.setFabricao(new Date());
			rodaLigaLeve2.setNome("Roda de liga leva modelo toyota etios");
			rodaLigaLeve2.setValidade(new Date());
			rodaLigaLeve2.setQuantidade(30);
			rodaLigaLeve2.setValor(300.0);
			rodaLigaLeve2.setDescricao("Roda de liga leve original de fábrica da toyta para modelos do tipo hatch");

			Servico alinhamento2 = new Servico();
			alinhamento2.setDescricao("Alinhamento das rodas do carro");
			alinhamento2.setNome("Alinhamento de rodas");
			alinhamento2.setValor(50);

			Servico balanceamento = new Servico();
			balanceamento.setDescricao("balanceamento das rodas do carro");
			balanceamento.setNome("balanceamento de rodas");
			balanceamento.setValor(30);

			Venda venda2 = new Venda();
			venda2.setCadastro(new Date());
			venda2.setCliente(cliente2);
			venda2.getMercadorias().add(rodaLigaLeve2);
			venda2.setIdentificacao("1234698749");
			venda2.setFuncionario(funcionario);
			venda2.getServicos().add(balanceamento);
			venda2.getServicos().add(alinhamento2);
			venda2.setVeiculo(veiculo);
			veiculo.getVendas().add(venda2);

			empresa.getVendas().add(venda2);

			repositorioEmpresa.save(empresa);

		}
	}

}
