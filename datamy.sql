-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 18-Dez-2016 às 15:59
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datamy`
--
CREATE DATABASE IF NOT EXISTS `datamy` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `datamy`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartaocredito`
--

CREATE TABLE `cartaocredito` (
  `id` int(11) NOT NULL,
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
  `id` int(11) NOT NULL,
  `valorComprado` double NOT NULL,
  `dataCompra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comprarelatorio`
--

CREATE TABLE `comprarelatorio` (
  `id` int(11) NOT NULL,
  `valorRelatorio` double NOT NULL,
  `dataCompraRelatorio` date NOT NULL,
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
  `id` int(11) NOT NULL,
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

INSERT INTO `usuario` (`idUsuario`, `cpf`, `email`, `perfil`, `status`, `username`, `password`, `transacoes_id`, `nomecompleto`) VALUES
(1, '117.237.364-73', 'pablosfictions@gmail.com', 'padrao', 'confirmacao', 'PabloAraujo', '123', NULL, 'hugo pablo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cartaocredito`
--
ALTER TABLE `cartaocredito`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chamado`
--
ALTER TABLE `chamado`
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
-- Indexes for table `estatistica`
--
ALTER TABLE `estatistica`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `relatoriochamados`
--
ALTER TABLE `relatoriochamados`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transacoes`
--
ALTER TABLE `transacoes`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `chamado`
--
ALTER TABLE `chamado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `compracredito`
--
ALTER TABLE `compracredito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
