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

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartaocredito`
--

CREATE TABLE `cartaocredito` (
  `idcartaoCredito` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cartaocredito`
--

INSERT INTO `cartaocredito` (`idcartaoCredito`, `numero`, `idUsuario`) VALUES
(1, 123, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `chamado`
--

CREATE TABLE `chamado` (
  `idChamado` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date DEFAULT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Em aberto',
  `descricao` varchar(255) NOT NULL,
  `pathImagem` varchar(255) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL,
  `idRelatorioChamados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compracredito`
--

CREATE TABLE `compracredito` (
  `idCompraCredito` int(11) NOT NULL,
  `valorComprado` double NOT NULL,
  `dataCompra` date NOT NULL,
  `idUsuario` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `compracredito`
--

INSERT INTO `compracredito` (`idCompraCredito`, `valorComprado`, `dataCompra`, `idUsuario`) VALUES
(1, 312312, '2016-12-12', '00:00:01'),
(2, 1231321313, '2016-12-12', '00:00:01'),
(3, 12, '2016-12-12', '00:00:01'),
(4, 100029444950, '2016-12-12', '00:00:01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `comprarelatorio`
--

CREATE TABLE `comprarelatorio` (
  `idCompraRelatorio` int(11) NOT NULL,
  `valorRelatorio` double NOT NULL,
  `dataCompraRelatorio` date NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estatistica`
--

CREATE TABLE `estatistica` (
  `idEstatistica` int(11) NOT NULL,
  `caminhoArquivo` varchar(255) NOT NULL,
  `idCompraRelatorio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatoriochamados`
--

CREATE TABLE `relatoriochamados` (
  `idRelatorioChamados` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL DEFAULT 'Diario',
  `dataRelatorioChamado` date NOT NULL,
  `caminhoArquivo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transacoes`
--

CREATE TABLE `transacoes` (
  `idTransacoes` int(11) NOT NULL,
  `dataTransacao` date NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `caminhoArquivo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `perfil` varchar(45) NOT NULL DEFAULT 'padrao',
  `status` varchar(45) NOT NULL DEFAULT 'confirmacao',
  `username` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `idTransacoes` int(11) DEFAULT NULL,
  `nomecompleto` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `cpf`, `email`, `perfil`, `status`, `username`, `password`, `idTransacoes`, `nomecompleto`) VALUES
(1, '117.237.364-73', 'pablosfictions@gmail.com', 'padrao', 'confirmacao', 'PabloAraujo', '123', NULL, 'hugo pablo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cartaocredito`
--
ALTER TABLE `cartaocredito`
  ADD PRIMARY KEY (`idcartaoCredito`);

--
-- Indexes for table `chamado`
--
ALTER TABLE `chamado`
  ADD PRIMARY KEY (`idChamado`);

--
-- Indexes for table `compracredito`
--
ALTER TABLE `compracredito`
  ADD PRIMARY KEY (`idCompraCredito`);

--
-- Indexes for table `comprarelatorio`
--
ALTER TABLE `comprarelatorio`
  ADD PRIMARY KEY (`idCompraRelatorio`);

--
-- Indexes for table `estatistica`
--
ALTER TABLE `estatistica`
  ADD PRIMARY KEY (`idEstatistica`);

--
-- Indexes for table `relatoriochamados`
--
ALTER TABLE `relatoriochamados`
  ADD PRIMARY KEY (`idRelatorioChamados`);

--
-- Indexes for table `transacoes`
--
ALTER TABLE `transacoes`
  ADD PRIMARY KEY (`idTransacoes`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cartaocredito`
--
ALTER TABLE `cartaocredito`
  MODIFY `idcartaoCredito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `chamado`
--
ALTER TABLE `chamado`
  MODIFY `idChamado` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `compracredito`
--
ALTER TABLE `compracredito`
  MODIFY `idCompraCredito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
