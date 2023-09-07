# Coğrafi Konum Tabanlı Hizmet Uygulaması

Bu uygulama, Türkiye sınırları içinde rastgele üretilen coğrafi konumları kullanarak interaktif bir harita deneyimi sunmayı amaçlar. Uygulama, hem backend hem de frontend bileşenlerini içerir ve şu temel adımları takip eder:

## Backend

1. Backend tarafında, Türkiye sınırları içinde rastgele oluşturulan enlem (latitude) ve boylam (longitude) değerleri kullanılır. Bu konum bilgileri, coğrafi konumları temsil eder.

2. Kafka adlı bir mesaj sırası (message queue) sistemi kullanılarak, bu rastgele konum bilgileri iletilir. Kafka sunucusu, Docker kullanılarak çalıştırılır ve Kafka mesajları izlemek ve denetlemek için Kafdrop adlı bir araç kullanılır.

3. Başka bir servis, Kafka'dan gelen konum bilgilerini WebSocket kullanarak bir frontend iletmek üzere yapılandırılır. Bu iletişimi sağlamak için STOMP protokolü kullanılır.

## Frontend

1. Frontend tarafında, WebSocket ile iletişim kurmak için STOMP ve SockJS kullanılır.

2. Kafka'dan gelen mesajlar "startloc" ve "endloc" bilgilerini içerir. Bu bilgiler, Google Directions API'ye gönderilir ve bu API, başlangıç ve bitiş noktalarına dayalı bir polyline (çizgi) döner.

3. Bu polyline kodlandığında, bir dizi "waypoints" (rota noktaları) elde edilir. "startloc" ve "endloc" bilgileri ile birlikte bu "waypoints" bilgileri WebSocket aracılığıyla Kafka'ya geri gönderilir ve bu bilgiler frontend tarafından alınır.

4. Kullanıcı, hangi aracın butonuna tıkladıysa, o aracın başlangıç ve bitiş noktalarını harita üzerinde görebilir. Ayrıca, "startloc" ve "endloc" noktalarına göre gelen waypoints'e dayalı olarak rota üzerinde hareket eden bir işaretçi (marker) görüntülenir.


<img src="[gorsel-link](https://github.com/Yareeen/microservice-project/blob/master/Proje_gorsel.gif)https://github.com/Yareeen/microservice-project/blob/master/Proje_gorsel.gif" width="auto">
