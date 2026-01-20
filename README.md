# Produtos-API

---

<p style="text-align:center;">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">API Endpoints</a>
</p>

<p style="text-align:center;">
    <b>Uma API que possibilita realizar um CRUD de produtos.</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

---
- Java
- Spring Boot
- MySQL

<h2 id="started">🚀 Getting started</h2>

<h3>Prerequisites</h3>

- Git >= `2.50.1`
- `Java JDK 21`
- `MySQL Server 8.0+ (testado na versão 9.3.0)`
- Recomendados: 
  - `IntelliJ IDEA`
  - `MySQL Workbench`
  - `Postman/Insomnia`

<h3>Cloning</h3>

```bash
git clone https://github.com/Gustavo-Falcao/Produtos-API.git
```
<h3>Config .properties variables</h2>

```properties
#Altere esses valores no arquivo (application.example.properties)
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

<h3>Starting</h3>

```bash
#Entre na pasta do projeto
cd Produtos-API

#Inicialize a API

#macOS / Linux
./mvnw spring-boot:run

#Windows
mvnw.cmd spring-boot:run
```
Depois acesse:
- `http://localhost:8080`

<h2 id="routes">📍 API Endpoints</h2>


| route                            | description      |                                    
|----------------------------------|------------------|
| <kbd>GET /produtos</kbd>         | retorna todos os produtos existentes na api, olhar [response details](#get-produtos)
| <kbd>GET /produtos/{id}</kbd>    | retorna o produto que corresponde ao id informado, olhar [response details](#get-produto-por-id)
| <kbd>POST /produtos</kbd>        | adiciona um produto na api, olhar [details](#post-produto)
| <kbd>POST /produtos/lote</kbd>   | adiciona uma lista de produtos na api, olhar [details](#post-produtos)
| <kbd>PUT /produtos</kbd>         | atualiza o valor de um produto na api, olhar [details](#put-produto)
| <kbd>DELETE /produtos/{id}</kbd> | deleta o produto da api que corresponde ao id informado, olhar [response details](#delete-produto)

<h3 id="get-produtos">GET /produtos</h3>

**RESPONSE**

<details>
<summary>Expandir lista de produtos</summary>   

```json
[
  {
    "nome": "Tablet Boreal Kids 8",
    "preco": 649,
    "quantidadeEstoque": 25,
    "descricao": "8\", capa antichoque, controle parental",
    "categoria": "Tablets"
  },
  {
    "nome": "Tablet Andromeda 10 SE",
    "preco": 999,
    "quantidadeEstoque": 28,
    "descricao": "10.1\" FHD, 4 GB, 64 GB",
    "categoria": "Tablets"
  },
  {
    "nome": "Teclado Magnético p/ Lyra 10",
    "preco": 349,
    "quantidadeEstoque": 22,
    "descricao": "Capa com teclado e trackpad",
    "categoria": "Tablets"
  },
  {
    "nome": "Roteador Wi-Fi 6 AX3000 Nova",
    "preco": 499,
    "quantidadeEstoque": 26,
    "descricao": "Dual band, WPA3, OFDMA",
    "categoria": "Redes"
  }
]
```

</details>

<h3 id="get-produto-por-id">GET /produtos/{id}</h3>

**RESPONSE**
```json
{
  "id": "004e9112-948a-40c3-8770-9c68b9c782fd",
  "nome": "Fone Bluetooth Nebula Pro",
  "preco": 499.9,
  "quantidadeEstoque": 60,
  "descricao": "TWS, cancelamento de ruído ativo, até 30h",
  "categoria": "Áudio"
}
```

<h3 id="post-produto">POST /produtos</h3>

**REQUEST**
```json
{
  "nome": "Fone Bluetooth Nebula Pro",
  "preco": 499.9,
  "quantidadeEstoque": 60,
  "descricao": "TWS, cancelamento de ruído ativo, até 30h",
  "categoria": "Áudio"
}
```

**RESPONSE**
```json
{
  "id": "004e9112-948a-40c3-8770-9c68b9c782fd",
  "nome": "Fone Bluetooth Nebula Pro",
  "preco": 499.9,
  "quantidadeEstoque": 60,
  "descricao": "TWS, cancelamento de ruído ativo, até 30h",
  "categoria": "Áudio"
}
```

<h3 id="post-produtos">POST /produtos/lote</h3>

**REQUEST**

<details>
<summary>Expandir lista de produtos</summary>    

```json
[
  {
    "nome": "Monitor 27\" Altair IPS",
    "preco": 1599,
    "quantidadeEstoque": 22,
    "descricao": "27\" 144 Hz, 1 ms, IPS, HDR10",
    "categoria": "Monitores"
  },
  {
    "nome": "Mouse Gamer Quasar",
    "preco": 149.9,
    "quantidadeEstoque": 80,
    "descricao": "12.000 DPI, RGB, 7 botões programáveis",
    "categoria": "Periféricos"
  }
]
```

</details>

**RESPONSE**

<details>
<summary>Expandir lista de produtos</summary>    

```json
[
  {
    "id": "0113ccbc-873c-4412-a07b-e38c3fa23054",
    "nome": "Monitor 27\" Altair IPS",
    "preco": 1599,
    "quantidadeEstoque": 22,
    "descricao": "27\" 144 Hz, 1 ms, IPS, HDR10",
    "categoria": "Monitores"
  },
  {
    "id": "01bc7557-9152-4c57-b0d2-fbdc307639c0",
    "nome": "Mouse Gamer Quasar",
    "preco": 149.9,
    "quantidadeEstoque": 80,
    "descricao": "12.000 DPI, RGB, 7 botões programáveis",
    "categoria": "Periféricos"
  }
]
```

</details>

<h3 id="put-produto">PUT /produtos</h3>

**ANTES**
```json
{
  "id": "004e9112-948a-40c3-8770-9c68b9c782fd",
  "nome": "Fone Bluetooth Nebula Pro",
  "preco": 499.9,
  "quantidadeEstoque": 25,
  "descricao": "TWS, cancelamento de ruído ativo, até 30h",
  "categoria": "Áudio"
}
```

**REQUEST**
```json
{
  "id": "004e9112-948a-40c3-8770-9c68b9c782fd",
  "nome": "Fone Bluetooth Nebula Pro",
  "preco": 499.9,
  "quantidadeEstoque": 60,
  "descricao": "TWS, cancelamento de ruído ativo, até 30h",
  "categoria": "Áudio"
}
```

**RESPONSE**
```json
{
  "id": "004e9112-948a-40c3-8770-9c68b9c782fd",
  "nome": "Fone Bluetooth Nebula Pro",
  "preco": 499.9,
  "quantidadeEstoque": 60,
  "descricao": "TWS, cancelamento de ruído ativo, até 30h",
  "categoria": "Áudio"
}
```

<h3 id="delete-produto">DELETE /produtos/{id}</h3>

**RESPONSE**

- `204 No Content`

---

<h3>Dados extra de produtos para inserir </h3>

<details>
<summary>Expandir dados</summary>

```json
[
  {
    "nome": "Teclado Mecânico Aurora",
    "preco": 329,
    "quantidadeEstoque": 40,
    "descricao": "Switches vermelho, ABNT2, RGB",
    "categoria": "Periféricos"
  },
  {
    "nome": "SSD NVMe 1 TB Pulsar",
    "preco": 449,
    "quantidadeEstoque": 50,
    "descricao": "Leitura 3500 MB/s, escrita 3000 MB/s",
    "categoria": "Armazenamento"
  },
  {
    "nome": "HD Externo 2 TB Comet",
    "preco": 389.9,
    "quantidadeEstoque": 33,
    "descricao": "USB 3.2, portátil, 2.5\"",
    "categoria": "Armazenamento"
  },
  {
    "nome": "Smartwatch Helix S",
    "preco": 699,
    "quantidadeEstoque": 27,
    "descricao": "GPS, SpO2, 5 ATM, bateria 10 dias",
    "categoria": "Wearables"
  },
  {
    "nome": "Tablet Lyra 10",
    "preco": 1399,
    "quantidadeEstoque": 19,
    "descricao": "10.4\" FHD, 6 GB RAM, 128 GB",
    "categoria": "Tablets"
  },
  {
    "nome": "Caixa de Som Pulse 30W",
    "preco": 299.9,
    "quantidadeEstoque": 55,
    "descricao": "Bluetooth 5.3, IPX7, estéreo",
    "categoria": "Áudio"
  },
  {
    "nome": "Roteador Wi-Fi 6 Nova AX1800",
    "preco": 349,
    "quantidadeEstoque": 32,
    "descricao": "Dual band, OFDMA, MU-MIMO",
    "categoria": "Redes"
  },
  {
    "nome": "Câmera de Ação Drift 4K",
    "preco": 999,
    "quantidadeEstoque": 14,
    "descricao": "4K60, estabilização, 2 baterias",
    "categoria": "Câmeras"
  },
  {
    "nome": "Headset USB Orion Call",
    "preco": 169.9,
    "quantidadeEstoque": 36,
    "descricao": "Microfone com redução de ruído, leve",
    "categoria": "Áudio"
  },
  {
    "nome": "Soundbar 120W Nova Cinema",
    "preco": 899,
    "quantidadeEstoque": 12,
    "descricao": "2.1 canais, subwoofer, HDMI ARC",
    "categoria": "Áudio"
  },
  {
    "nome": "Leitor de Cartões MultiX",
    "preco": 79.9,
    "quantidadeEstoque": 90,
    "descricao": "USB-C/USB-A, SD e microSD UHS-II",
    "categoria": "Acessórios"
  },
  {
    "nome": "Hub USB-C 6-em-1 Atlas",
    "preco": 259,
    "quantidadeEstoque": 28,
    "descricao": "HDMI 4K, 3x USB, PD, SD",
    "categoria": "Acessórios"
  },
  {
    "nome": "Microfone Condensador Stream",
    "preco": 349,
    "quantidadeEstoque": 24,
    "descricao": "USB, cardioide, tripé incluso",
    "categoria": "Áudio"
  },
  {
    "nome": "Switch Gigabit 8 Portas Core",
    "preco": 199,
    "quantidadeEstoque": 26,
    "descricao": "8x RJ45, fanless, metal",
    "categoria": "Redes"
  },
  {
    "nome": "TV 50\" 4K Andromeda",
    "preco": 2199,
    "quantidadeEstoque": 13,
    "descricao": "VA 60 Hz, HDR10, Smart TV",
    "categoria": "TVs"
  },
  {
    "nome": "Câmera Mirrorless Aster M10",
    "preco": 3499,
    "quantidadeEstoque": 7,
    "descricao": "24 MP, vídeo 4K30, lente 15-45mm",
    "categoria": "Câmeras"
  },
  {
    "nome": "Caixa de Som Smart EchoBeat",
    "preco": 449,
    "quantidadeEstoque": 33,
    "descricao": "Assistente de voz, Wi-Fi/Bluetooth",
    "categoria": "Áudio"
  },
  {
    "nome": "Repetidor/Mesh Wi-Fi NovaMesh M1",
    "preco": 429,
    "quantidadeEstoque": 29,
    "descricao": "AX3000, roaming contínuo",
    "categoria": "Redes"
  },
  {
    "nome": "Headphone Studio Orion One",
    "preco": 379,
    "quantidadeEstoque": 26,
    "descricao": "Over-ear, cabo destacável, 40 mm",
    "categoria": "Áudio"
  },
  {
    "nome": "Leitor Biométrico SecureID USB",
    "preco": 269,
    "quantidadeEstoque": 22,
    "descricao": "Impressão digital, SDK incluso",
    "categoria": "Acessórios"
  },
  {
    "nome": "Dock USB-C Pro 11-em-1 Atlas Max",
    "preco": 589,
    "quantidadeEstoque": 17,
    "descricao": "2x HDMI 4K, 1x DP, 3x USB, RJ45, SD, PD",
    "categoria": "Acessórios"
  },
  {
    "nome": "Smartphone Orion Z Lite",
    "preco": 2199,
    "quantidadeEstoque": 25,
    "descricao": "6.1\" OLED, 128 GB, 5G, câmera 48 MP",
    "categoria": "Smartphones"
  },
  {
    "nome": "Notebook Vega 15 Pro",
    "preco": 5999,
    "quantidadeEstoque": 9,
    "descricao": "Ryzen 7, 16 GB, SSD 1 TB, 15.6\" 120 Hz",
    "categoria": "Notebooks"
  },
  {
    "nome": "Monitor 34\" UltraWide Helios",
    "preco": 2899,
    "quantidadeEstoque": 11,
    "descricao": "3440x1440, 144 Hz, 1 ms, HDR400",
    "categoria": "Monitores"
  },
  {
    "nome": "Mouse Sem Fio Aero Slim",
    "preco": 119.9,
    "quantidadeEstoque": 70,
    "descricao": "Bluetooth/2.4G, 1600 DPI, recarregável",
    "categoria": "Periféricos"
  },
  {
    "nome": "Teclado Low Profile Nimbus",
    "preco": 429,
    "quantidadeEstoque": 28,
    "descricao": "Switch óptico, ABNT2, RGB",
    "categoria": "Periféricos"
  },
  {
    "nome": "Headset Gamer Vega 7.1",
    "preco": 299.9,
    "quantidadeEstoque": 34,
    "descricao": "Som 7.1 virtual, microfone removível",
    "categoria": "Áudio"
  },
  {
    "nome": "SSD SATA 480 GB Core",
    "preco": 199,
    "quantidadeEstoque": 65,
    "descricao": "Leitura 550 MB/s, escrita 480 MB/s",
    "categoria": "Armazenamento"
  },
  {
    "nome": "SSD NVMe 2 TB Comet Pro",
    "preco": 899,
    "quantidadeEstoque": 15,
    "descricao": "Leitura 7000 MB/s, escrita 6500 MB/s",
    "categoria": "Armazenamento"
  },
  {
    "nome": "HD Interno 4 TB Atlas",
    "preco": 699,
    "quantidadeEstoque": 20,
    "descricao": "7200 RPM, 3.5\", cache 256 MB",
    "categoria": "Armazenamento"
  },
  {
    "nome": "Roteador Wi-Fi 6E Nova AXE5400",
    "preco": 1099,
    "quantidadeEstoque": 13,
    "descricao": "Tri-band, OFDMA, MU-MIMO, WPA3",
    "categoria": "Redes"
  },
  {
    "nome": "Adaptador USB Wi-Fi AX300",
    "preco": 139.9,
    "quantidadeEstoque": 80,
    "descricao": "USB-A, Wi-Fi 6, antena destacável",
    "categoria": "Redes"
  },
  {
    "nome": "Switch Gigabit 16 Portas Rack",
    "preco": 399,
    "quantidadeEstoque": 18,
    "descricao": "16x RJ45, metal, fanless",
    "categoria": "Redes"
  },
  {
    "nome": "Microfone USB PodCast X",
    "preco": 449,
    "quantidadeEstoque": 22,
    "descricao": "Cardioide, ganho e mute, shock mount",
    "categoria": "Áudio"
  },
  {
    "nome": "Câmera de Ação Drift 4K Mini",
    "preco": 749,
    "quantidadeEstoque": 19,
    "descricao": "4K30, corpo compacto, prova d’água",
    "categoria": "Câmeras"
  },
  {
    "nome": "Smartwatch Helix Fit",
    "preco": 899,
    "quantidadeEstoque": 21,
    "descricao": "GPS, NFC, 50 m, bateria 7 dias",
    "categoria": "Wearables"
  },
  {
    "nome": "Soundbar 240W Nova Cinema Plus",
    "preco": 1499,
    "quantidadeEstoque": 8,
    "descricao": "3.1 canais, subwoofer sem fio, DTS",
    "categoria": "Áudio"
  },
  {
    "nome": "Caixa de Som 50W Pulse Max",
    "preco": 449,
    "quantidadeEstoque": 38,
    "descricao": "Bluetooth 5.3, IP67, pareamento estéreo",
    "categoria": "Áudio"
  },
  {
    "nome": "TV 55\" 4K Andromeda QLED",
    "preco": 3499,
    "quantidadeEstoque": 10,
    "descricao": "120 Hz, HDR10+, Dolby Vision, Smart",
    "categoria": "TVs"
  },
  {
    "nome": "TV 65\" 4K Andromeda MiniLED",
    "preco": 5299,
    "quantidadeEstoque": 6,
    "descricao": "144 Hz, VRR, Dolby Atmos",
    "categoria": "TVs"
  },
  {
    "nome": "Smartphone Orion X Plus",
    "preco": 3199,
    "quantidadeEstoque": 16,
    "descricao": "6.7\" AMOLED, 256 GB, 5G, câmera 64 MP",
    "categoria": "Smartphones"
  },
  {
    "nome": "Smartphone Orion M",
    "preco": 1799,
    "quantidadeEstoque": 30,
    "descricao": "6.3\" IPS, 128 GB, 5G, câmera dupla",
    "categoria": "Smartphones"
  },
  {
    "nome": "Smartphone Helix A3",
    "preco": 1499.9,
    "quantidadeEstoque": 45,
    "descricao": "6.5\" 90 Hz, 128 GB, bateria 5000 mAh",
    "categoria": "Smartphones"
  },
  {
    "nome": "Smartphone Vega One SE",
    "preco": 1199,
    "quantidadeEstoque": 28,
    "descricao": "6.1\" OLED, 64 GB, 4G, NFC",
    "categoria": "Smartphones"
  },
  {
    "nome": "Notebook Vega 14 Slim",
    "preco": 6499,
    "quantidadeEstoque": 8,
    "descricao": "Intel i7, 16 GB, SSD 1 TB, 14\" FHD",
    "categoria": "Notebooks"
  },
  {
    "nome": "Notebook Boreal 15",
    "preco": 3599,
    "quantidadeEstoque": 14,
    "descricao": "Ryzen 5, 8 GB, SSD 512 GB, 15.6\" FHD",
    "categoria": "Notebooks"
  },
  {
    "nome": "Notebook Helios Pro 16",
    "preco": 10999,
    "quantidadeEstoque": 5,
    "descricao": "Intel i9, 32 GB, SSD 1 TB, RTX 4060, 16\" 165 Hz",
    "categoria": "Notebooks"
  },
  {
    "nome": "Notebook Andromeda 13",
    "preco": 5899,
    "quantidadeEstoque": 9,
    "descricao": "Core Ultra 5, 16 GB, SSD 512 GB, 13.3\"",
    "categoria": "Notebooks"
  },
  {
    "nome": "Fone TWS Pulse Mini",
    "preco": 179.9,
    "quantidadeEstoque": 70,
    "descricao": "Bluetooth 5.3, estojo 20h, IPX4",
    "categoria": "Áudio"
  },
  {
    "nome": "Headset Over-Ear Nova Studio",
    "preco": 299,
    "quantidadeEstoque": 32,
    "descricao": "Drivers 50 mm, cabo 2 m",
    "categoria": "Áudio"
  },
  {
    "nome": "Caixa de Som 20W Wave",
    "preco": 189.9,
    "quantidadeEstoque": 50,
    "descricao": "BT 5.0, rádio FM, 12h bateria",
    "categoria": "Áudio"
  },
  {
    "nome": "Soundbar 320W Cinema X",
    "preco": 1999,
    "quantidadeEstoque": 7,
    "descricao": "3.1.2 canais, Dolby Atmos, HDMI eARC",
    "categoria": "Áudio"
  },
  {
    "nome": "Monitor 24\" IPS Prime",
    "preco": 799,
    "quantidadeEstoque": 26,
    "descricao": "1080p, 75 Hz, borda fina",
    "categoria": "Monitores"
  },
  {
    "nome": "Monitor 32\" QHD Orion",
    "preco": 1999,
    "quantidadeEstoque": 12,
    "descricao": "2560x1440, 144 Hz, 1 ms",
    "categoria": "Monitores"
  },
  {
    "nome": "Monitor 27\" 4K Creator",
    "preco": 1899,
    "quantidadeEstoque": 10,
    "descricao": "UHD, 60 Hz, 99% sRGB, HDR10",
    "categoria": "Monitores"
  },
  {
    "nome": "Monitor 29\" UltraWide Neo",
    "preco": 1399,
    "quantidadeEstoque": 18,
    "descricao": "2560x1080, 100 Hz, FreeSync",
    "categoria": "Monitores"
  },
  {
    "nome": "Mouse Office Silent",
    "preco": 69.9,
    "quantidadeEstoque": 110,
    "descricao": "Silencioso, 1200 DPI, 2.4 GHz",
    "categoria": "Periféricos"
  },
  {
    "nome": "Mouse Gamer Flux 8K",
    "preco": 349,
    "quantidadeEstoque": 22,
    "descricao": "26.000 DPI, polling 8K, RGB",
    "categoria": "Periféricos"
  },
  {
    "nome": "Teclado Mecânico TKL Storm",
    "preco": 379,
    "quantidadeEstoque": 27,
    "descricao": "Switch marrom, TKL, ABNT2",
    "categoria": "Periféricos"
  },
  {
    "nome": "Combo Teclado e Mouse Wave",
    "preco": 199.9,
    "quantidadeEstoque": 44,
    "descricao": "Sem fio, baixo perfil, recarregável",
    "categoria": "Periféricos"
  },
  {
    "nome": "SSD NVMe 500 GB CoreX",
    "preco": 299,
    "quantidadeEstoque": 40,
    "descricao": "PCIe 4.0, 5000/4500 MB/s",
    "categoria": "Armazenamento"
  },
  {
    "nome": "SSD SATA 1 TB Atlas S",
    "preco": 349,
    "quantidadeEstoque": 33,
    "descricao": "2.5\", 560/520 MB/s",
    "categoria": "Armazenamento"
  },
  {
    "nome": "HD Externo 1 TB Pocket",
    "preco": 279,
    "quantidadeEstoque": 36,
    "descricao": "USB 3.2, compacto 2.5\"",
    "categoria": "Armazenamento"
  },
  {
    "nome": "Cartão microSD 256 GB Ultra",
    "preco": 169.9,
    "quantidadeEstoque": 85,
    "descricao": "A2, U3, 4K",
    "categoria": "Armazenamento"
  },
  {
    "nome": "Smartwatch Helix S Pro",
    "preco": 1299,
    "quantidadeEstoque": 13,
    "descricao": "GPS multi-banda, ECG, 5 ATM",
    "categoria": "Wearables"
  },
  {
    "nome": "Pulseira Fitness TrackFit 2",
    "preco": 229.9,
    "quantidadeEstoque": 48,
    "descricao": "SpO2, 14 dias de bateria, 5 ATM",
    "categoria": "Wearables"
  },
  {
    "nome": "Smartwatch Orion Move",
    "preco": 899,
    "quantidadeEstoque": 20,
    "descricao": "Tela AMOLED, GPS, chamadas BT",
    "categoria": "Wearables"
  },
  {
    "nome": "Fone Esportivo RunBeat",
    "preco": 249.9,
    "quantidadeEstoque": 40,
    "descricao": "Ganchos auriculares, IPX5, 24h",
    "categoria": "Wearables"
  },
  {
    "nome": "Tablet Lyra 11 Pro",
    "preco": 2199,
    "quantidadeEstoque": 12,
    "descricao": "11\" 120 Hz, 8 GB, 256 GB",
    "categoria": "Tablets"
  },
  {
    "nome": "Tablet Boreal Kids 8",
    "preco": 649,
    "quantidadeEstoque": 25,
    "descricao": "8\", capa antichoque, controle parental",
    "categoria": "Tablets"
  },
  {
    "nome": "Tablet Andromeda 10 SE",
    "preco": 999,
    "quantidadeEstoque": 28,
    "descricao": "10.1\" FHD, 4 GB, 64 GB",
    "categoria": "Tablets"
  },
  {
    "nome": "Teclado Magnético p/ Lyra 10",
    "preco": 349,
    "quantidadeEstoque": 22,
    "descricao": "Capa com teclado e trackpad",
    "categoria": "Tablets"
  },
  {
    "nome": "Roteador Wi-Fi 6 AX3000 Nova",
    "preco": 499,
    "quantidadeEstoque": 26,
    "descricao": "Dual band, WPA3, OFDMA",
    "categoria": "Redes"
  },
  {
    "nome": "Kit Mesh NovaMesh M2 (2 Unid.)",
    "preco": 899,
    "quantidadeEstoque": 15,
    "descricao": "Cobertura 300 m², backhaul Ethernet",
    "categoria": "Redes"
  },
  {
    "nome": "Switch Gigabit 24 Portas Rack",
    "preco": 699,
    "quantidadeEstoque": 10,
    "descricao": "24x RJ45, QoS, fanless",
    "categoria": "Redes"
  },
  {
    "nome": "Adaptador USB-C p/ RJ45 2.5GbE",
    "preco": 239,
    "quantidadeEstoque": 34,
    "descricao": "USB-C, 2.5 Gbps, plug and play",
    "categoria": "Redes"
  },
  {
    "nome": "Câmera IP Dome Guard 2K",
    "preco": 319,
    "quantidadeEstoque": 29,
    "descricao": "2K, detecção humana, áudio bidirecional",
    "categoria": "Câmeras"
  },
  {
    "nome": "Webcam 1080p Pro Call",
    "preco": 229,
    "quantidadeEstoque": 31,
    "descricao": "1080p60, foco automático, tampa",
    "categoria": "Câmeras"
  },
  {
    "nome": "Câmera de Ação 1080p Lite",
    "preco": 299,
    "quantidadeEstoque": 24,
    "descricao": "1080p60, 30 m com case, Wi-Fi",
    "categoria": "Câmeras"
  },
  {
    "nome": "Câmera IP Bullet Outdoor",
    "preco": 279,
    "quantidadeEstoque": 35,
    "descricao": "1080p, IP66, visão noturna 30 m",
    "categoria": "Câmeras"
  },
  {
    "nome": "Leitor de Cartões DualUS",
    "preco": 69.9,
    "quantidadeEstoque": 120,
    "descricao": "USB-C/USB-A, SD/microSD UHS-I",
    "categoria": "Acessórios"
  },
  {
    "nome": "Hub USB-C 9-em-1 Prime",
    "preco": 329,
    "quantidadeEstoque": 21,
    "descricao": "HDMI 4K, 3x USB, RJ45, SD, PD",
    "categoria": "Acessórios"
  },
  {
    "nome": "Suporte Articulado p/ Monitor",
    "preco": 239,
    "quantidadeEstoque": 26,
    "descricao": "22–32\", ajuste de altura e rotação",
    "categoria": "Acessórios"
  },
  {
    "nome": "Base Refrigerada p/ Notebook",
    "preco": 129.9,
    "quantidadeEstoque": 44,
    "descricao": "Até 17\", 2 coolers, USB pass-through",
    "categoria": "Acessórios"
  },
  {
    "nome": "TV 43\" 4K Andromeda",
    "preco": 1699,
    "quantidadeEstoque": 18,
    "descricao": "UHD, HDR10, Smart TV",
    "categoria": "TVs"
  },
  {
    "nome": "TV 50\" 4K Andromeda QLED Pro",
    "preco": 2999,
    "quantidadeEstoque": 9,
    "descricao": "120 Hz, Dolby Vision/Atmos, VRR",
    "categoria": "TVs"
  },
  {
    "nome": "TV 75\" 4K Andromeda Max",
    "preco": 5999,
    "quantidadeEstoque": 4,
    "descricao": "VA 120 Hz, HDR10+, Smart",
    "categoria": "TVs"
  },
  {
    "nome": "TV 32\" HD Boreal",
    "preco": 899,
    "quantidadeEstoque": 25,
    "descricao": "HD, Wi-Fi, apps principais",
    "categoria": "TVs"
  },
  {
    "nome": "Fone Bluetooth Studio ANC",
    "preco": 599,
    "quantidadeEstoque": 19,
    "descricao": "Over-ear, ANC híbrido, 40h",
    "categoria": "Áudio"
  },
  {
    "nome": "Roteador Wi-Fi 6 AX5400 Nova Pro",
    "preco": 799,
    "quantidadeEstoque": 14,
    "descricao": "Dual-core, 160 MHz, WPA3",
    "categoria": "Redes"
  },
  {
    "nome": "Smartphone Helix S Lite",
    "preco": 1599,
    "quantidadeEstoque": 32,
    "descricao": "6.2\" 90 Hz, 128 GB, 5G, câmera 50 MP",
    "categoria": "Smartphones"
  },
  {
    "nome": "Smartphone Andromeda Note",
    "preco": 2899,
    "quantidadeEstoque": 14,
    "descricao": "6.7\" AMOLED, 256 GB, 5G, caneta stylus",
    "categoria": "Smartphones"
  },
  {
    "nome": "Notebook Vega 14 Business",
    "preco": 6299,
    "quantidadeEstoque": 7,
    "descricao": "Core i7, 16 GB, SSD 512 GB, leitor biométrico",
    "categoria": "Notebooks"
  },
  {
    "nome": "Notebook Boreal 16 Gaming Lite",
    "preco": 5599,
    "quantidadeEstoque": 6,
    "descricao": "Ryzen 5, 16 GB, RTX 3050, SSD 512 GB, 16\" 120 Hz",
    "categoria": "Notebooks"
  },
  {
    "nome": "Fone TWS Pulse Pro ANC",
    "preco": 399,
    "quantidadeEstoque": 52,
    "descricao": "Cancelamento ativo híbrido, 30h com estojo",
    "categoria": "Áudio"
  },
  {
    "nome": "Caixa de Som Outdoor Wave 60W",
    "preco": 549,
    "quantidadeEstoque": 21,
    "descricao": "BT 5.3, IP67, powerbank integrado",
    "categoria": "Áudio"
  },
  {
    "nome": "Headset Gamer Flux 7X",
    "preco": 329,
    "quantidadeEstoque": 29,
    "descricao": "7.1 virtual, microfone destacável, RGB",
    "categoria": "Áudio"
  },
  {
    "nome": "Monitor 27\" QHD Helios 165",
    "preco": 1799,
    "quantidadeEstoque": 13,
    "descricao": "2560x1440, 165 Hz, 1 ms, FreeSync",
    "categoria": "Monitores"
  },
  {
    "nome": "Monitor 24\" Esports Neo 144",
    "preco": 1099,
    "quantidadeEstoque": 20,
    "descricao": "1080p, 144 Hz, 1 ms, base ajustável",
    "categoria": "Monitores"
  },
  {
    "nome": "Mouse Gamer Quasar Mini",
    "preco": 189.9,
    "quantidadeEstoque": 66,
    "descricao": "Ultraleve 59 g, 19.000 DPI, RGB",
    "categoria": "Periféricos"
  },
  {
    "nome": "Teclado Mecânico Office Silent",
    "preco": 299,
    "quantidadeEstoque": 31,
    "descricao": "Switch silencioso, ABNT2, descanso de pulso",
    "categoria": "Periféricos"
  },
  {
    "nome": "SSD NVMe 4 TB Comet X",
    "preco": 1499,
    "quantidadeEstoque": 9,
    "descricao": "PCIe 4.0, 7300/6800 MB/s, dissipador",
    "categoria": "Armazenamento"
  },
  {
    "nome": "HD Externo 5 TB Atlas Shield",
    "preco": 649,
    "quantidadeEstoque": 17,
    "descricao": "USB 3.2, 2.5\", criptografia por senha",
    "categoria": "Armazenamento"
  },
  {
    "nome": "Smartwatch Orion Trail",
    "preco": 1699,
    "quantidadeEstoque": 8,
    "descricao": "GPS multibanda, mapas offline, 10 ATM",
    "categoria": "Wearables"
  },
  {
    "nome": "Pulseira Fitness TrackFit 3",
    "preco": 299,
    "quantidadeEstoque": 42,
    "descricao": "Tela AMOLED, SpO2, 20 dias de bateria",
    "categoria": "Wearables"
  },
  {
    "nome": "Tablet Lyra 13 Max",
    "preco": 3299,
    "quantidadeEstoque": 6,
    "descricao": "13\" 120 Hz, 12 GB RAM, 256 GB, teclado opcional",
    "categoria": "Tablets"
  },
  {
    "nome": "Roteador Wi-Fi 6 AX1800 Compact",
    "preco": 329,
    "quantidadeEstoque": 28,
    "descricao": "Dual band, WPA3, OFDMA, app de gestão",
    "categoria": "Redes"
  },
  {
    "nome": "Switch 5 Portas Gigabit Metal",
    "preco": 129.9,
    "quantidadeEstoque": 40,
    "descricao": "Fanless, QoS básico, case metálico",
    "categoria": "Redes"
  },
  {
    "nome": "Webcam 2K Stream Pro",
    "preco": 259,
    "quantidadeEstoque": 27,
    "descricao": "1440p30, foco automático, tampa de privacidade",
    "categoria": "Câmeras"
  },
  {
    "nome": "Suporte de Notebook Alumínio Fold",
    "preco": 119.9,
    "quantidadeEstoque": 58,
    "descricao": "Dobrável, 6 níveis de altura, até 17\"",
    "categoria": "Acessórios"
  }
]
```

</details>