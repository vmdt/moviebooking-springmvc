-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: moviebooking
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `actors` text,
  `description` text,
  `directors` text,
  `duration` int(11) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `nation_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a3d4p2j4too4rnb0k19xatoxr` (`nation_id`),
  KEY `FK_5fm50m41poafs2eoglck7efki` (`type_id`),
  CONSTRAINT `FK_5fm50m41poafs2eoglck7efki` FOREIGN KEY (`type_id`) REFERENCES `movie_type` (`id`),
  CONSTRAINT `FK_a3d4p2j4too4rnb0k19xatoxr` FOREIGN KEY (`nation_id`) REFERENCES `nation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,NULL,NULL,NULL,NULL,'Miu Lê, Lãnh Thanh, Karik, Phương Anh Đào','Chiếm Đoạt kể về người vợ của một gia đình thượng lưu thuê cô bảo mẫu “trong mơ” để chăm sóc con trai mình. Nhưng cô không ngờ rằng, phía sau sự trong sáng, tinh khiết kia, cô bảo mẫu luôn che giấu âm mưu nhằm phá hoại hạnh phúc gia đình và khiến cuộc sống của cô thay đổi mãi mãi.','Thắng Vũ',97,'Tiếng Việt','Chiếm Đoạt','/resources/images/chiemdoat-1.jpg',1,1),(2,NULL,NULL,NULL,NULL,'Kaity Nguyễn - Thuận Nguyễn - NSƯT Quang Thắng','Lấy cảm hứng từ tiểu thuyết Hồ Oán Hận, của nhà văn Hồng Thái, Người Vợ Cuối Cùng là một bộ phim tâm lý cổ trang, lấy bối cảnh Việt Nam vào triều Nguyễn','Victor Vũ',132,'Tiếng Việt','Người Vợ Cuối Cùng','/resources/images/nguoivocuoicung-2.jpg',1,1),(3,NULL,NULL,NULL,NULL,'Hứa Vĩ Văn, Thu Trang, Kiều Minh Tuấn, Tiến Luật','Nghề Siêu Dễ được cải biên dựa trên kịch bản gốc Extreme Job. Đây là là tác phẩm có doanh thu cao thứ hai mọi thời đại của Hàn Quốc. Nội dung phim xoay quanh câu chuyện một cảnh sát về hưu tên Thái (Hứa Vỹ Văn).','Võ Thanh Hòa',113,'Tiếng Việt','Nghề Siêu Dễ','/resources/images/nghesieude-3.jpg',1,2),(4,NULL,NULL,NULL,NULL,'Kang Ha-neul, Jung So-min, Kim Sun-young, Lim Chul-hyung, Yoon Kyung-ho, Jo Min-soo','Cặp vợ chồng trẻ No Jung Yeol (Kang Ha-neul) và Hong Na Ra (Jung So-min) từ cuộc sống hôn nhân màu hồng dần “hiện nguyên hình” trở thành cái gai trong mắt đối phương với vô vàn thói hư, tật xấu. Không thể đi đến tiếng nói chung, Jung Yeol và Na Ra quyết định ra toà ly dị.','Nam Dae-jung',119,'Tiếng Hàn - Phụ đề','Yêu Lại Vợ Ngầu','/resources/images/yeulaivongau-4.jpg',3,1),(5,NULL,NULL,NULL,NULL,'Kang Ha-neul, Jung So-min, Kim Sun-young, Lim Chul-hyung, Yoon Kyung-ho, Jo Min-soo','Cặp vợ chồng trẻ No Jung Yeol (Kang Ha-neul) và Hong Na Ra (Jung So-min) từ cuộc sống hôn nhân màu hồng dần “hiện nguyên hình” trở thành cái gai trong mắt đối phương với vô vàn thói hư, tật xấu. Không thể đi đến tiếng nói chung, Jung Yeol và Na Ra quyết định ra toà ly dị.','Nam Dae-jung',119,'Tiếng Hàn - Phụ đề','Yêu Lại Vợ Ngầu','/resources/images/yeulaivongau-4.jpg',3,1),(6,NULL,NULL,NULL,NULL,'Lisa Ambalavarna, Sydney Craven, Andrew Horton','Được thúc đẩy để trở thành chủ tịch hội nữ sinh, Emily cố gắng nhanh chóng trở nên nổi tiếng bằng cách nuôi một chú lười đáng yêu làm linh vật của hội. Tuy nhiên, kế hoạch của Emily đã dẫn đến cuộc tàn sát mà mục tiêu được nhắm đến là các thành viên nữ sinh trong hội dưới bàn tay của con lười, linh vật mà Emily yêu quý - Alpha.','Matthew Goodhue',93,'Tiếng Anh - Phụ đề','Cuộc Truy Đuổi Kỳ Quái','/resources/images/cuoctruyduoikyquai-5.jpg',2,3),(7,NULL,NULL,NULL,NULL,'Anna Kendrick, Zooey Deschanel, Justin Timberlake','Sự xuất hiện đột ngột của John Dory, anh trai thất lạc đã lâu của Branch mở ra quá khứ bí mật được che giấu bấy lâu nay của Branch. Đó là quá khứ về một ban nhạc có tên BroZone từng rất nổi tiếng nhưng đã tan rã. Hành trình đi tìm lại các thành viên để làm một ban nhạc như xưa trở thành chuyến phiêu lưu âm nhạc đầy cảm xúc, tràn trề hi vọng về một cuộc sum họp gia đình tuyệt với nhất.','Walt Dohrn, Tim Heitz',92,'Tiếng Anh - Phụ đề','Quỷ Lùn Tinh Nghịch','/resources/images/quyluntinhnghich-6.jpg',2,2),(8,NULL,NULL,NULL,NULL,'Hồng Ánh, Huỳnh Hạo Khang, Mai Tài Phến, Công Ninh','Đất Rừng Phương Nam phiên bản điện ảnh được kế thừa và phát triển từ tiểu thuyết cùng tên của nhà văn Đoàn Giỏi. Bộ phim kể về hành trình phiêu lưu của An - một cậu bé chẳng may mất mẹ trên đường đi tìm cha. Cùng với An, khán giả sẽ trải nghiệm sự trù phú của thiên nhiên và nét đẹp văn hoá đặc sắc của vùng đất Nam Kì Lục Tỉnh, sự hào hiệp của những người nông dân bám đất bám rừng và tinh thần yêunước kháng Pháp đầu thế kỉ 20.','Nguyễn Quang Dũng',110,'Tiếng Việt','Đất Rừng Phương Nam','/resources/images/datrungphuongnam.jpg',1,1),(9,NULL,NULL,NULL,NULL,'Leonardo DiCaprio, Kate Winslet',' là một bộ phim thuộc hàng kinh điển của Hollywood, bộ phim kể về một chuyện tình thật đẹp thật lãng mạn trên chiếc thuyền dành cho quý tộc, chuyện tình giữa một nàng tiểu thư giới thượng lưu cùng chàng trai nghèo khổ.Phim kể về chiếc tàu mang tên Titanic, con tàu mà đối với nhiều người lúc đó ...','James Cameron',194,'Tiếng Anh - Phụ đề','Titanic','/resources/images/titanic.jpg',2,1),(10,NULL,NULL,NULL,NULL,'Huỳnh Hiểu Minh, Dương Tử, Trương Triết Hạn','Liệt Hỏa Anh Hùng được đánh giá là một trong những bộ phim chiếu rạp Trung Quốc thành công với đề tài về những người lính cứu hỏa. Phim khắc họa chân thật những góc khuất đằng sau hình ảnh người lính cứu hỏa oai hùng. ','Tony Chan',120,'Tiếng Trung - Phụ đề','Liệt Hỏa Anh Hùng','/resources/images/liethoaanhhung.jpg',4,1),(11,NULL,NULL,NULL,NULL,'Viggo Mortensen, Mahershala Ali, Linda Cardellini','Người gác cửa Tony Lip là người Mỹ gốc Ý, thuộc tầng lớp lao động và về học vấn không vượt quá lớp bảy. Bởi vì câu lạc bộ Copacabana, nơi anh làm việc, đóng cửa trong vài tháng do phải tái thiết vào năm 1962, Tony nhận làm tài xế cho một người Mỹ gốc Phi, Don Shirley, một người quý phái và nghệ sĩ dương cầm có học thức, rất tài năng và là một người bạn của gia đình Kennedy và sống trong một căn hộ giống như bảo tàng phía trên tòa nhà trình diễn âm nhạc nổi tiếng Carnegie Hall.','Peter Farrelly',130,'Tiếng Anh - Phụ đề','Green Book','/resources/images/greenbook.jpg',2,2),(12,NULL,NULL,NULL,NULL,'Daniel Kaluuya, Allison Williams','Bộ phim xoay quanh Chris - chàng thanh niên da màu đa tài trong chuyến thăm gia đình người bạn gái da trắng của anh trong dịp cuối tuần. Lần theo những bí mật khủng khiếp dần được vén màn, Chris không thể ngờ rằng cuộc gặp gỡ gia đình bạn gái đã biến thành một cái bẫy chết người tại vùng đất sặc mùi quỷ ám.','Jordan Peele',104,'Tiếng Anh - Phụ đề','Get Out','/resources/images/getout.jpg',2,3),(13,NULL,NULL,NULL,NULL,'Matthew McConaughey, Anne Hathaway','Trong tương lai, các nguồn tài nguyên thiên nhiên trên trái đất dần cạn kiệt dẫn loài người tới bờ của sự huỷ diệt, thức ăn khan hiếm và NASA thì không còn nữa.','Christopher Nolan',169,'Tiếng Anh - Phụ đề','Interstellar','/resources/images/interstellar.jpg',2,4),(14,NULL,NULL,NULL,NULL,'Son Ye-jin, Hyun Bin, Seo Ji-hye','Gặp sự cố khi chơi dù lượn, nữ thừa kế người Hàn Quốc phải đáp xuống Triều Tiên. Cũng vì vậy mà cô gặp gỡ chàng quân nhân tốt bụng – người quyết định giúp cô ẩn náu.','Park Ji-eun',90,'Tiếng Hàn - Phụ đề','Hạ cánh nơi anh','/resources/images/hacanhnoianh.jpg',3,2),(15,NULL,NULL,NULL,NULL,'Tom Hiddleston, Owen Wilson','Một chương mới của Marvel với Loki là trung tâm của câu chuyện.','Michael Waldron',90,'Tiếng Anh - Phụ đề','Loki','/resources/images/loki.jpg',2,4);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-17 22:51:08
