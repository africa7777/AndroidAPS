package info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.status;

import info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.AppLayerMessage;
import info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.Service;
import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.MessagePriority;
import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.TotalDailyDose;
import info.nightscout.androidaps.plugins.PumpInsightLocal.utils.ByteBuf;

public class GetTotalDailyDoseMessage extends AppLayerMessage {

    private TotalDailyDose tdd;

    public GetTotalDailyDoseMessage() {
        super(MessagePriority.NORMAL, true, false, Service.STATUS);
    }

    @Override
    protected void parse(ByteBuf byteBuf) {
        tdd = new TotalDailyDose();
        tdd.setBolus(byteBuf.readUInt32Decimal100());
        tdd.setBasal(byteBuf.readUInt32Decimal100());
        tdd.setBolusAndBasal(byteBuf.readUInt32Decimal100());
    }

    public TotalDailyDose getTDD() {
        return this.tdd;
    }
}
