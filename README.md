# Geolokalization
Zaimplementować wydajną usługę REST, której zadaniem będzie odbieranie i zapisywanie informacji o pozycjach (geolokalizacji) z urządzeń mobilnych np. telefon/lokalizator GPS. Przykład formatu danych z urządzeń: {'deviceId':'12345', 'latitiude': 505430, 'longitude': 1423412}.

Aplikacja łączy sie z fake API (zaimplementowany mock w testach).Klasa RestClientTest.java testuje funkcjonalność zaimplementowanego rozwiązania skutkiem pozytywnego przejścia testów jest zapisanie w bazie danych zamockowanego wcześniej położenia urządzenia.
