package app.editor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.event.DocumentEvent.EventType;
import javax.swing.text.AbstractDocument.DefaultDocumentEvent;
import javax.swing.undo.UndoableEdit;

public class MyUndoableListener implements UndoableEditListener {

    public static int MAX_SAVES = 50;
    private int maxSaved = MAX_SAVES;
    private List<UndoableEdit> actions = new ArrayList<UndoableEdit>();
    private List<UndoableEdit> undos = new ArrayList<UndoableEdit>();
    private List<UndoableEdit> redos = new ArrayList<UndoableEdit>();

    public void setMaxSaves(int max) {
        this.maxSaved = max;
    }

    public void undoableEditHappened(UndoableEditEvent e) {
        if (actions.size() == maxSaved) {
            return;
        }
        if (e.getEdit() instanceof DefaultDocumentEvent) {
            if (((DefaultDocumentEvent) e.getEdit()).getType() == EventType.CHANGE) {
                return;
            }
        }

        actions.add(e.getEdit());
    }

    public void undo() {
        if (actions.size() == 0) {
            return;
        }

        UndoableEdit edit = actions.remove(actions.size() - 1);
        undos.add(edit);

        edit.undo();
    }

    public void redo() {
        if (undos.size() == 0) {
            return;
        }

        UndoableEdit edit = undos.remove(undos.size() - 1);
        redos.add(edit);

        edit.redo();
    }
}
