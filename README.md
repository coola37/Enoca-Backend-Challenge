<p> SpringDoc Pdf ->  [chalange-doc.pdf](https://github.com/coola37/Enoca-Backend-Challenge/files/14380305/chalange-doc.pdf)</p>

# Entities
## BaseEntity
<p>Diğer entity sınıflarının temelini oluşturan bir sınıftır. Bu sınıf, tüm entity sınıflarında ortak olan birincil anahtar (ID) alanını içerir.</p>

## Product
<p>Mağazada satılan ürünleri temsil eder. Ürünlerin adı, fiyatı ve stok durumu gibi özellikleri bulunmaktadır.</p>

## Cart
<p>Müşterilerin sepetlerini temsil eder. Her sepet bir müşteriye ait olabilir ve içinde birden çok ürün bulunabilir.</p>

## CartItem
<p>Sepetteki her bir ürünü temsil eder. Bir ürünün sepet içindeki miktarı (quantity) ve hangi sepete ait olduğu gibi bilgileri içerir.</p>

## Customer
<p>Müşterileri temsil eder. Her müşterinin bir ismi, e-posta adresi, bir sepeti ve siparişleri bulunabilir.</p>

## Order
<p>Müşterilerin verdiği siparişleri temsil eder. Her sipariş bir müşteriye ait olabilir ve içinde birden çok sipariş kalemi (OrderItem) bulunabilir.</p>

## OrderItem
<p>Bir sipariş içindeki her bir ürünü ve miktarını temsil eder. Bir sipariş kaleminin bir ürünle ilişkisi, miktarı ve fiyatı gibi bilgileri içerir.</p>
  
# Services
## ProductService
<p>getProduct(): Belirli bir ürünü ID'ye göre getirir.</p>
<p>createProduct(): Yeni bir ürün oluşturur.</p>
<p>updateProduct(): Mevcut bir ürünü günceller.</p>
<p>deleteProduct(): Belirli bir ürünü siler.</p>

## CartService
<p>createCart(): Yeni bir alışveriş sepeti oluşturur.</p>
<p>getCart(): Belirli bir alışveriş sepetini getirir.</p>
<p>updateCart(): Mevcut bir alışveriş sepetini günceller.</p>
<p>emptyCart(): Bir alışveriş sepetini boşaltır.</p>
<p>addProductToCart(): Bir ürünü sepete ekler.</p>
<p>cartItemChangeQuantity(): Sepet içindeki bir ürünün miktarını değiştirir.</p>
<p>removeProductFromCart(): Sepetten bir ürünü kaldırır.</p>

## CustomerService
<p>addCustomer(): Yeni bir müşteri oluşturur.</p>
<p>getCustomer(): Belirli bir müşteriyi getirir.</p>
<p>getAllOrdersForCustomer(): Belirli bir müşterinin tüm siparişlerini getirir.</p>

## OrderService
<p>placeOrder(): Bir sipariş oluşturur ve işlemleri gerçekleştirir.</p>
<p>getOrderForCode(): Belirli bir siparişi getirir.</p>
<p>cartConvertToOrder(): Bir alışveriş sepetini bir siparişe dönüştürür.</p>

# Controller
## CartController
<p>/get/{cartId} (GET): Belirli bir alışveriş sepetini almak için kullanılır. Sepetteki ürünlerin toplam fiyatını hesaplar ve sonuçları döndürür.</p>
<p>/update/{cartId} (PUT): Belirli bir alışveriş sepetini güncellemek için kullanılır. Sepetin içeriğini ve toplam fiyatını günceller.</p>
<p>/empty-cart/{cartId} (PUT): Belirli bir alışveriş sepetini boşaltmak için kullanılır.</p>
<p>/add-product-tocart/{productId}/{cartId}/{quantity} (PUT): Belirli bir alışveriş sepetine belirli bir ürünü ve miktarını eklemek için kullanılır.</p>
<p>/remove-product-from-cart/{cartId}/{cartItemId} (PUT): Belirli bir alışveriş sepetinden belirli bir ürünü kaldırmak için kullanılır.</p>
<p>/change-item-quantity/{cartId}/{cartListIndex}/{changeQuantity} (PUT): Belirli bir alışveriş sepetindeki bir ürünün miktarını değiştirmek için kullanılır.</p>

## CustomerController
<p>/create (POST): Yeni bir müşteri oluşturur ve müşteriye ait bir alışveriş sepeti oluşturur.</p>
<p>/{customerId} (GET): Belirli bir müşteriyi almak için kullanılır.</p>
<p>/place-order/{customerId} (PUT): Belirli bir müşterinin sipariş vermesini sağlar.</p>
<p>/get-all-orders-for-customer/{customerId} (GET): Belirli bir müşterinin tüm siparişlerini almak için kullanılır.</p>
<p>/get-order-for-code/{orderId} (GET): Belirli bir siparişi almak için kullanılır.</p>

## ProductController
<p>/ (POST): Yeni bir ürün oluşturur.</p>
<p>/get/{productId} (GET): Belirli bir ürünü almak için kullanılır.</p>
<p>/update/{productId} (PUT): Belirli bir ürünü güncellemek için kullanılır.</p>
<p>/delete/{productId} (DELETE): Belirli bir ürünü silmek için kullanılır.</p>
