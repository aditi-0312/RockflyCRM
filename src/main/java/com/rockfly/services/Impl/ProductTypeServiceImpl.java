package com.rockfly.services.Impl;

import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.rockfly.dto.BarcodeDTO;
import com.rockfly.dto.CustomerDTO;
import com.rockfly.models.Customers;
import com.rockfly.models.MainStock;
import com.rockfly.models.Price;
import com.rockfly.models.ProductType;
import com.rockfly.repositories.MainStockRepository;
import com.rockfly.repositories.ProductTypeRepository;
import com.rockfly.services.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private MainStockRepository mainStockRepository;
	
//	@Autowired
//	private PriRepo
	
	@Override
	public void addProductType(ProductType productType) {
		
		productTypeRepository.save(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		
		return productTypeRepository.findAll();
	}
	
	
	//to display product variation on the barcode page, so barcode can be generated
//	@Override
//	public List<BarcodeDTO> getProdutsForBarcode() {
//		List<MainStock> mainStock = mainStockRepository.findAll();
//		return mainStock.stream()
//				.map(this::fromEntityToDTO)
//				.collect(Collectors.toList());
//	}
	
//	@Override
//	public List<BarcodeDTO> getProdutsForBarcode() {
//	    List<MainStock> mainStock = mainStockRepository.findAll();
//	    return mainStock.stream()
//	            .map(stock -> {
//	                Price price = priceRepository.findByMainStockId(stock.getId()); // assuming there's a method to get the price by main stock id
//	                return fromEntityToDTO(stock, price);
//	            })
//	            .collect(Collectors.toList());
//	}
	
//	public static byte[] getBarCodeImage(String text,int width, int height) {
//		try {
//			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap=new Hashtable<>();
//			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//			Writer writer = new Code128Writer();
//			BitMatrix bitMatrix=writer.encode(text, BarcodeFormat.CODE_128, width, height);
//			ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
//			return byteArrayOutputStream.toByteArray();
//		} catch (Exception e) {
//			return null;
//		}
//	}
//	
//	@Override
//	public BarcodeDTO fromEntityToDTO(MainStock mainStock, Price price) {
//		return new BarcodeDTO(mainStock.getStyleNumber(), mainStock.getColor(), mainStock.getSize(),price.getMrp());
//	}
}
