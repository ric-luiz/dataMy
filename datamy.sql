-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 19-Dez-2016 às 00:11
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datamy`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartaocredito`
--

CREATE TABLE `cartaocredito` (
  `id` int(11) UNSIGNED NOT NULL,
  `nomeTitular` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `chamado`
--

CREATE TABLE `chamado` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date DEFAULT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Em aberto',
  `descricao` varchar(255) NOT NULL,
  `pathImagem` varchar(255) DEFAULT NULL,
  `usuario_id` int(11) NOT NULL,
  `relatorioChamado_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compracredito`
--

CREATE TABLE `compracredito` (
  `id` int(11) UNSIGNED NOT NULL,
  `valorComprado` int(11) NOT NULL,
  `dataCompra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroparcelas` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `compracredito`
--

INSERT INTO `compracredito` (`id`, `valorComprado`, `dataCompra`, `numeroparcelas`, `usuario_id`) VALUES
(16, 1000, '2016-12-18 22:17:37', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `comprarelatorio`
--

CREATE TABLE `comprarelatorio` (
  `id` int(11) UNSIGNED NOT NULL,
  `valorRelatorio` double NOT NULL,
  `dataCompraRelatorio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estatistica`
--

CREATE TABLE `estatistica` (
  `id` int(11) NOT NULL,
  `caminhoArquivo` varchar(255) NOT NULL,
  `compraRelatorio_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatoriochamados`
--

CREATE TABLE `relatoriochamados` (
  `id` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL DEFAULT 'Diario',
  `dataRelatorioChamado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `caminhoArquivo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transacoes`
--

CREATE TABLE `transacoes` (
  `id` int(11) NOT NULL,
  `dataTransacao` date NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `caminhoArquivo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) UNSIGNED NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `perfil` varchar(45) NOT NULL DEFAULT 'padrao',
  `status` varchar(45) NOT NULL DEFAULT 'confirmacao',
  `username` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `transacoes_id` int(11) DEFAULT NULL,
  `nomecompleto` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `cpf`, `email`, `perfil`, `status`, `username`, `password`, `transacoes_id`, `nomecompleto`) VALUES
(1, '117.237.364-73', 'pablosfictions@gmail.com', 'padrao', 'confirmacao', 'PabloAraujo', '123', NULL, 'hugo pablo'),
(2, '01646998480', 'luiz@luiz', 'padrao', 'confirmacao', 'luiz', '123', NULL, 'luiz silva');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cartaocredito`
--
ALTER TABLE `cartaocredito`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `compracredito`
--
ALTER TABLE `compracredito`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comprarelatorio`
--
ALTER TABLE `comprarelatorio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cartaocredito`
--
ALTER TABLE `cartaocredito`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `compracredito`
--
ALTER TABLE `compracredito`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `comprarelatorio`
--
ALTER TABLE `comprarelatorio`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
