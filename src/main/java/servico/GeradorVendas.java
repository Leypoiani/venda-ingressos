package servico;

import model.Venda;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import serializer.VendaSerializer;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class GeradorVendas {

    private static Random random = new Random();
    private static long operacao = 0;
    private static BigDecimal valorIngresso = BigDecimal.valueOf(500);

    public static void main(String[] args) throws InterruptedException {

        //propriedades da conexão kafka
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());

        try (KafkaProducer<String, Venda> producer = new KafkaProducer<String, Venda>(properties)) {


            while (true) {
                Venda venda = geraVenda();
                ProducerRecord record = geraProducerRecord(venda);
                producer.send(record);
                Thread.sleep(200);
            }
        }
    }

    private static Venda geraVenda() {
        long cliente = random.nextLong();
        int qtdIngressos = random.nextInt();
        return new Venda(operacao++, cliente, qtdIngressos, valorIngresso.multiply(BigDecimal.valueOf(qtdIngressos)));
    }

    private static ProducerRecord geraProducerRecord(Venda venda) {
        return new ProducerRecord<String, Venda>("venda-ingressos", venda);
    }
}
