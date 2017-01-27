-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27-Jan-2017 às 03:05
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
  `id` int(10) UNSIGNED NOT NULL,
  `nomeTitular` varchar(255) NOT NULL,
  `numero` int(10) UNSIGNED NOT NULL,
  `usuario_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cartaocredito`
--

INSERT INTO `cartaocredito` (`id`, `nomeTitular`, `numero`, `usuario_id`) VALUES
(1, 'luiz', 1653127323, 1),
(2, 'luiz silva junior', 1276351, 1),
(3, 'junior luiz silva', 213542112, 1),
(4, 'luiz junior silva', 13151673, 1),
(5, 'luiz silva Junior', 4313422, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `chamado`
--

CREATE TABLE `chamado` (
  `id` int(10) UNSIGNED NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `dataInicio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(255) NOT NULL,
  `dataFim` datetime DEFAULT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Em aberto',
  `descricao` varchar(255) NOT NULL,
  `pathImagem` varchar(255) DEFAULT NULL,
  `usuario_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `chamado`
--

INSERT INTO `chamado` (`id`, `titulo`, `dataInicio`, `tipo`, `dataFim`, `status`, `descricao`, `pathImagem`, `usuario_id`) VALUES
(1, 'teste suporte', '2017-01-26 23:21:22', 'Pagamento', NULL, 'Em aberto', 'teste de suporte', NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `comprarelatorio`
--

CREATE TABLE `comprarelatorio` (
  `id` int(10) UNSIGNED NOT NULL,
  `dataCompraRelatorio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `valorCompra` double UNSIGNED NOT NULL,
  `parcelas` int(10) UNSIGNED NOT NULL,
  `quantidade` int(10) UNSIGNED NOT NULL,
  `usuario_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `comprarelatorio`
--

INSERT INTO `comprarelatorio` (`id`, `dataCompraRelatorio`, `valorCompra`, `parcelas`, `quantidade`, `usuario_id`) VALUES
(1, '2017-01-21 19:59:19', 200, 9, 5, 1),
(7, '2017-01-24 23:53:51', 400, 2, 10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estatistica`
--

CREATE TABLE `estatistica` (
  `id` int(10) UNSIGNED NOT NULL,
  `caminhoArquivo` varchar(255) NOT NULL,
  `compraRelatorio_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estatistica`
--

INSERT INTO `estatistica` (`id`, `caminhoArquivo`, `compraRelatorio_id`) VALUES
(1, 'teste', 1),
(2, 'outro teste', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(10) UNSIGNED NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `nomecompleto` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `perfil` varchar(50) NOT NULL DEFAULT '''padrao''',
  `status` varchar(50) NOT NULL DEFAULT '''confirmar''',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `cpf`, `nomecompleto`, `email`, `perfil`, `status`, `username`, `password`) VALUES
(1, '01646998480', 'ricardo luiz da silva junior', 'junior@gmail.com', '''padrao''', '''confirmar''', 'luiz', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cartaocredito`
--
ALTER TABLE `cartaocredito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indexes for table `chamado`
--
ALTER TABLE `chamado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indexes for table `comprarelatorio`
--
ALTER TABLE `comprarelatorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indexes for table `estatistica`
--
ALTER TABLE `estatistica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `compraRelatorio_id` (`compraRelatorio_id`);

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
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `chamado`
--
ALTER TABLE `chamado`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `comprarelatorio`
--
ALTER TABLE `comprarelatorio`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `estatistica`
--
ALTER TABLE `estatistica`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cartaocredito`
--
ALTER TABLE `cartaocredito`
  ADD CONSTRAINT `usuarioCartao_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `chamado`
--
ALTER TABLE `chamado`
  ADD CONSTRAINT `chamadoUsuario_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `comprarelatorio`
--
ALTER TABLE `comprarelatorio`
  ADD CONSTRAINT `usuarioCompraRelatorio_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `estatistica`
--
ALTER TABLE `estatistica`
  ADD CONSTRAINT `estatisticaCompraRelatorio_fk` FOREIGN KEY (`compraRelatorio_id`) REFERENCES `comprarelatorio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;