-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13 Jun 2019 pada 17.20
-- Versi Server: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itcell`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('aity', 'computer');

-- --------------------------------------------------------

--
-- Struktur dari tabel `berita`
--

CREATE TABLE `berita` (
  `id_berita` int(11) NOT NULL,
  `nama` text,
  `detail` text,
  `deskripsi` text,
  `photo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `berita`
--

INSERT INTO `berita` (`id_berita`, `nama`, `detail`, `deskripsi`, `photo`) VALUES
(7, 'xxxy', '23900', '0000-00-00', ''),
(8, 'xxxy', '900', '0000-00-00', ''),
(9, 'admin', '48244', '0000-00-00', ''),
(10, 'bb', '38500', '0000-00-00', ''),
(11, 'bb', '36000', '0000-00-00', ''),
(12, 'bbm', '217020', '0000-00-00', ''),
(13, 'admin', '36630', '0000-00-00', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobiles`
--

CREATE TABLE `mobiles` (
  `id_mobile` int(11) NOT NULL,
  `detail` text,
  `nama` text,
  `mdescription` text,
  `mphoto` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mobiles`
--

INSERT INTO `mobiles` (`id_mobile`, `detail`, `nama`, `mdescription`, `mphoto`) VALUES
(1, 'Nokia', '3310', '-Highly durable\r\n-SMS\r\n-Phonebook\r\n-Snake\r\n-Space Impact', 'nokia-3310.jpg'),
(2, 'Motorola', 'C113', '-Blue display\r\n-SMS\r\n-Phonebook\r\n-Game', 'motorola_c113_00.jpg'),
(4, 'Nokia', '6110', 'Three games: Memory, Snake, Logic\r\nCalculator, clock and calendar\r\nCurrency converter\r\nWorks as a pager\r\nProfile settings\r\n4 colours\r\n', 'Nokia 6110.jpg'),
(5, 'Motorola', 'ROKR', 'Calculator, clock and calendar\r\nThree games: Memory, Snake, Logic\r\nCurrency converter\r\nWorks as a pager\r\nProfile settings\r\n2 colours\r\n', 'Motorola ROKR.jpg'),
(6, 'Nokia', '8810', 'Calculator, clock and calendar\r\nThree games: Memory, Snake, Logic\r\nCurrency converter\r\nWorks as a pager\r\nProfile settings\r\n5 colours\r\n', 'Nokia 8810.jpg'),
(7, 'Citycell', 'c130', 'Calculator, clock and calendar\r\nCurrency converter\r\nProfile settings\r\n\r\n', 'Citycell.jpg'),
(8, ' Sony', 'CMD-Z1', 'GSM phone\r\n', 'Sony.jpg'),
(9, 'Samsung ', 'D100', 'GSM phone\r\n', 'ssd100.gif'),
(10, 'Nokia', '1100', 'Snake\r\nSpace Impact\r\n500 contact entry\r\n', 'nokia 1100.jpg'),
(11, 'ZTE ', 'Coral200 Sollar', 'Pager view\r\n500 contact entry\r\n', 'ZTE Coral200 Sollar.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tips`
--

CREATE TABLE `tips` (
  `id_tips` int(11) NOT NULL,
  `nama` text,
  `detail` text,
  `deskripsi` text,
  `photo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tips`
--

INSERT INTO `tips` (`id_tips`, `nama`, `detail`, `deskripsi`, `photo`) VALUES
(7, 'xxxy', '23900', '0000-00-00', ''),
(8, 'xxxy', '900', '0000-00-00', ''),
(9, 'admin', '48244', '0000-00-00', ''),
(10, 'bb', '38500', '0000-00-00', ''),
(11, 'bb', '36000', '0000-00-00', ''),
(12, 'bbm', '217020', '0000-00-00', ''),
(13, 'admin', '36630', '0000-00-00', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `berita`
--
ALTER TABLE `berita`
  ADD PRIMARY KEY (`id_berita`);

--
-- Indexes for table `mobiles`
--
ALTER TABLE `mobiles`
  ADD PRIMARY KEY (`id_mobile`);

--
-- Indexes for table `tips`
--
ALTER TABLE `tips`
  ADD PRIMARY KEY (`id_tips`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `berita`
--
ALTER TABLE `berita`
  MODIFY `id_berita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `mobiles`
--
ALTER TABLE `mobiles`
  MODIFY `id_mobile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tips`
--
ALTER TABLE `tips`
  MODIFY `id_tips` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
