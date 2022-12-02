-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Des 2022 pada 05.00
-- Versi server: 10.6.5-MariaDB
-- Versi PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spotify_soap`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `logging`
--

CREATE TABLE `logging` (
  `id` int(11) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `IP` varchar(16) DEFAULT NULL,
  `endpoint` varchar(256) DEFAULT NULL,
  `requested_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `logging`
--

INSERT INTO `logging` (`id`, `description`, `IP`, `endpoint`, `requested_at`) VALUES
(1, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:52:02'),
(2, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:52:10'),
(3, 'menanggapi request subscription', '::1', '/service/subscription', '2022-12-02 03:52:19'),
(4, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:52:25'),
(5, 'menanggapi request subscription', '::1', '/service/subscription', '2022-12-02 03:52:30'),
(6, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:52:32'),
(7, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:53:15'),
(8, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:53:19'),
(9, 'menanggapi request subscription', '::1', '/service/subscription', '2022-12-02 03:53:45'),
(10, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:53:46'),
(11, 'menanggapi request subscription', '::1', '/service/subscription', '2022-12-02 03:53:59'),
(12, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:54:01'),
(13, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:54:06'),
(14, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:54:48'),
(15, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:55:27'),
(16, 'menanggapi reject subscription', '::1', '/service/subscription', '2022-12-02 03:55:45'),
(17, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:55:47'),
(18, 'menanggapi approve subscription', '::1', '/service/subscription', '2022-12-02 03:55:49'),
(19, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:55:50'),
(20, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:56:18'),
(21, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:56:19'),
(22, 'menanggapi permintaan subscription request', '::1', '/service/subscription', '2022-12-02 03:57:18'),
(23, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:58:05'),
(24, 'revalidasi data', '::1', '/service/subscription', '2022-12-02 03:58:37');

-- --------------------------------------------------------

--
-- Struktur dari tabel `subscription`
--

CREATE TABLE `subscription` (
  `creator_id` int(11) NOT NULL,
  `subscriber_id` int(11) NOT NULL,
  `status` enum('PENDING','ACCEPTED','REJECTED') DEFAULT 'PENDING'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `subscription`
--

INSERT INTO `subscription` (`creator_id`, `subscriber_id`, `status`) VALUES
(1, 978574100, 'ACCEPTED'),
(2, 978574100, 'PENDING'),
(4, 978574100, 'REJECTED'),
(5, 978574100, 'PENDING'),
(7, 978574100, 'PENDING'),
(8, 978574100, 'ACCEPTED'),
(10, 978574100, 'PENDING'),
(12, 978574100, 'PENDING'),
(13, 978574100, 'REJECTED'),
(14, 978574100, 'PENDING'),
(15, 978574100, 'PENDING'),
(16, 978574100, 'PENDING'),
(17, 978574100, 'PENDING'),
(18, 978574100, 'PENDING'),
(20, 978574100, 'PENDING');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `logging`
--
ALTER TABLE `logging`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`creator_id`,`subscriber_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `logging`
--
ALTER TABLE `logging`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
