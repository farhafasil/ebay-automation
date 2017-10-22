package mock;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import model.UserLoginModel;

public class SequenceManagerMock {
	private JSONObject _sequences;
	
	
	public SequenceManagerMock() throws Exception{
		InputStream sequenceStream = UserManagerMock.class.getResourceAsStream("../data/sequence.json");
		String data = IOUtils.toString(sequenceStream);
		this._sequences = new JSONObject(data);
	}
	
	
	public JSONObject getSequence(String sequence) throws Exception{
		JSONObject selectedSequence = _sequences.getJSONObject(sequence);
		return selectedSequence;
	}
}
